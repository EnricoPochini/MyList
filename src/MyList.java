import java.util.Arrays;

public class MyList<T>{

    private Node<T> head;


    public MyList(){

        head = null;

    }//costruttore

    /**
     * @param element elemento da aggiungere in coda
     */
    public void add(T element){

        Node<T> add = new Node<>(element);

        if(head == null){

            head = add;
            return;

        }//if

        Node<T> curr = head;
        while(curr.getLink() != null){

            curr = curr.getLink();

        }//while
        curr.setLink(add);

    }

    /**
     * @param element elemento da aggiungere alla lista
     * @param index posizione nella lista nel quale aggiungere element
     */
    public void add(T element,int index){

        Node<T> curr = head;
        int pos = 0;
        while(curr != null && pos < index){

            curr = curr.getLink();
            pos++;

        }//while

        if(curr == null) curr = new Node<>(element);
        if(curr.getLink() == null) curr.setLink(new Node<T>(element));
        if(curr.getLink() != null){

            Node<T> next = curr.getLink();
            curr.setLink(new Node<T>(element));
            curr.getLink().setLink(next);

        }//if

    }

    /**
     * @param element elemento da aggiungere all'inizio della lista
     */
    public void addFirst(T element){

        Node<T> curr = new Node<>(element);
        curr.setLink(head);
        head = curr;

    }

    /**
     * @param index posizione dell'elemento da ritornare
     * @return T - elemeto in posizione index
     * @throws IndexOutOfBoundsException
     */
    public T get(int index){

        Node curr = head;
        int count = 0;
        while(curr != null && count < index){

            curr= curr.getLink();
            count++;

        }//while

        if(curr == null) throw new IndexOutOfBoundsException("Elemento non trovato, index maggiore della grandezza");

        return (T) curr.getElement();
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

        Node<T> curr = head;
        int pos = 0;
        Node<T> prev = head;
        while(curr != null && pos < index){

            prev = curr;
            curr = curr.getLink();
            pos++;

        }//while

        if(curr == null && pos < index) {

            throw new IndexOutOfBoundsException("La lista non ha abbastanza elementi da arrivare al " + index + "° elemento");

        }//if

        if(curr.getLink() == null) {

            prev = null;

        }//if

        if(curr.getLink() != null){

            Node<T> temp = curr.getLink();
            prev.setLink(temp);

        }//if

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
