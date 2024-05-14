@SuppressWarnings("ALL")
public class MyList<T>{

    private Node<T> head;
    private Node<T> tail;


    public MyList(){

        head = null;
        tail=null;

    }//costruttore



    /**
     * @param element elemento da aggiungere in coda
     */
    public void add(T element){

        if(head == null){

            head = new Node<>(element);
            tail=head;
            return;

        }//if

        Node<T> curr = head;
        while(curr.getLink() != null){

            curr = curr.getLink();

        }//while

        curr.setLink(new Node<>(element));
        tail = curr.getLink();
        tail.setPrev(curr);


    }



    /**
     * @param element elemento da aggiungere alla lista
     * @param index posizione nella lista nel quale aggiungere element
     */
    public void add(T element,int index){

        int size = size();

        if(size == index){

            addLast(element);
            return;

        }//if

        if(index == 0){

            addFirst(element);
            return;

        }//if

        Node<T> curr = head;
        int pos = 0;
        while(curr != null && pos < index && curr.getLink() != null){

            curr = curr.getLink();
            pos++;

        }//while

        if(curr.getLink() == null){

            curr.setLink(new Node<T>(curr,element));
            tail = curr.getLink();

        }//if
        if(curr.getLink() != null){

            curr.setLink(new Node<>(curr,element,curr.getLink()));

        }//if

    }



    /**
     * aggiunge un nuovo elemento alla fine
     * @param element da aggiungere
     */
    public void addLast(T element){

        if(isEmpty()){

            add(element);
            return;

        }//if

        Node<T> prev = tail.getPrev();
        tail = new Node<>(element);
        tail.setPrev(prev);
        prev.setLink(tail);

    }



    /**
     * @param element elemento da aggiungere all'inizio della lista
     */
    public void addFirst(T element){

        if(head==null){

            add(element);
            return;

        }//if

        if(head.getLink() == null){

            tail = head;
            head = new Node<>(element);
            head.setLink(tail);
            tail.setPrev(head);
            return;

        }//if

        Node<T> curr = new Node<>(element);
        head.setPrev(curr);
        curr.setLink(head);
        head = curr;

    }



    /**
     * @param index posizione dell'elemento da ritornare
     * @return T - elemeto in posizione index
     * @throws IndexOutOfBoundsException
     */
    public T get(int index){

        int size = size();

        if(size-1 == index) return tail.getElement();

        if(index == 0) return head.getElement();

        if((size / 2) <= index){

            int count = 1;
            int nCicli = size-index;
            Node<T> curr = tail;

            while(count < nCicli){

                curr = curr.getPrev();
                count++;

            }//while

            return curr.getElement();

        }//if

        Node<T> curr = head;
        int count = 0;
        while(curr != null && count < index){

            curr= curr.getLink();
            count++;

        }//while

        if(curr == null) throw new IndexOutOfBoundsException("Elemento non trovato, index maggiore della grandezza");

        return (T) curr.getElement();
    }



    /**
     * @param index posizione del nodo da ritornare
     * @return Node - nodo in posizione index
     * @throws IndexOutOfBoundsException
     */
    private Node<T> getNode(int index){

        int size = size();

        if(size-1 == index) return tail;

        if(index == 0) return head;

        if((size / 2) <= index){

            int count = 1;
            int nCicli = size-index;
            Node<T> curr = tail;

            while(count < nCicli){

                curr = curr.getPrev();
                count++;

            }//while

            return curr;

        }//if

        Node<T> curr = head;
        int count = 0;
        while(curr != null && count < index){

            curr= curr.getLink();
            count++;

        }//while

        if(curr == null) throw new IndexOutOfBoundsException("Elemento non trovato, index maggiore della grandezza");

        return curr;
    }



    /**
     * @return il primo elemento della lista
     */
    public T getFirst(){

        return head.getElement();

    }



    /**
     * @return l'ultimo elemento della lista
     */
    public T getLast(){

        return tail.getElement();

    }



    /**
     * @return l'ultimo nodo della lista
     * @deprecated
     */
    private Node<T> getLastNode(){

        return tail;

    }



    /**@return int - numero di elementi presenti nella lista
     */
    public int size(){

        int size = 0;
        Node<T> curr = head;
        while(curr != null){

            curr = curr.getLink();
            size++;

        }//while

        return size;
    }



    /**
     * rimuove tutti gli elementi della lista
     */
    public void clear(){

        head = null;
        tail = null;

    }



    /**
     * @return MyList una lista identitca a questa
     */
    public MyList<T> clone(){

        return this;

    }



    /**
     * @param index posizione dell'element da rimuovere
     * @return true se l'elemento è stato rimosso
     * @throws IndexOutOfBoundsException
     */
    public boolean remove(int index){

        int size = size();

        if(index == 0) head = head.getLink();

        if(size-1 == index){

            tail = tail.getPrev();

        }//if

        if((size / 2) <= index){

            int count = 1;
            int nCicli = size-index;
            Node<T> curr = tail;

            while(count < nCicli){

                curr = curr.getPrev();
                count++;

            }//while

            curr.getPrev().setLink(curr.getLink());

            return true;

        }//if

        Node<T> curr = head;
        int count = 0;
        while(curr != null && count < index){

            curr= curr.getLink();
            count++;

        }//while

        if(curr == null) {

            throw new IndexOutOfBoundsException("La lista non ha abbastanza elementi da arrivare al " + index + "° elemento");

        }//if

        curr.getPrev().setLink(curr.getLink());

        return true;

    }



    /**
     * @param element da rimuovere
     * @return true se l'elemento è stato rimosso
     * @throws IndexOutOfBoundsException
     */
    public boolean remove(T element){

        Node<T> prev = null;
        Node<T> curr = head;

        while(curr != null){

            if(curr.getElement().equals(element)){

                Node<T> temp = curr.getLink();
                prev.setLink(temp);
                return true;

            }//if

            prev = curr;
            curr = curr.getLink();

        }//while

        return false;

    }



    /**
     * @return true se l'ultimo elemento è stato rimosso
     */
    public void removeLast(){

        tail = tail.getPrev();

    }



    /**
     * @return true se la lista è vuota
     */
    public boolean isEmpty(){

        if(head == null) return true;
        return false;

    }



    /**
     * @param element elemento da verificare
     * @return true se element è presente nella lista
     */
    public boolean contains(T element){

        Node<T> curr = head;

        while(curr != null){

            if(curr.getElement().equals(element)){

                return true;

            }//if

            curr = curr.getLink();

        }//while

        return false;

    }



    /**
     * @param element elemento da cercare
     * @return int - pos dell'elemento
     * @return -1 - se l'elemento non è presente
     */
    public int indexOf(T element){

        int pos = 0;
        Node<T> curr = head;

        while(curr != null){

            if(curr.getElement().equals(element)){

                return pos;

            }//if

            curr = curr.getLink();
            pos++;

        }//while

        return -1;

    }



    /**
     * @return la lista trasformata in un array
     */
    public Object[] toArray(){

        Object[] arr = new Object[size()];
        Node<T> curr = head;
        int currIndex = 0;

        while(curr!=null){

            arr[currIndex] = curr.getElement();
            curr = curr.getLink();
            currIndex++;

        }//while

        return arr;

    }



    /**inverte gli elementi della lista, il primo diventa l'ultimo e viceversa
     */
    public void reverse(){

        MyList<T> newList = new MyList<>();

        int size = size();
        for(int i=1;i<size;i++){

            newList.add(get(size-i));

        }//for

        head = newList.head;


    }



    /**
     * @param firstIndex primo elemento del range da prelevare
     * @param secondIndex secondo range fino a quale prelevare
     * @return una sotto lista deglie elementi firstIndex -> secondIndex
     */
    public MyList<T> subList(int firstIndex, int secondIndex){

        MyList<T> subList = new MyList<>();
        Node<T> curr = head;

        int nodeCurr = 0;
        curr = getNode(firstIndex);
        while(curr != null && nodeCurr <= secondIndex){

            subList.add(curr.getElement());
            curr = curr.getLink();

        }//while

        return subList;

    }



    /**
     * @return String tutti i toString() degli element della lista
     */
    public String toString(){

        String content = "";
        Node<T> curr = head;

        while(curr != null){

            content = content + curr.getElement().toString() + "\n";
            curr = curr.getLink();

        }//while

        return content;

    }



}
