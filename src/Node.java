public class Node<T> {

    private Node prev;
    private T element;
    private Node link;

    public Node(T element){

        prev = null;
        this.element=element;
        link = null;

    }//costruttore

    public Node(Node prev,T element){

        this.prev = prev;
        this.element=element;
        link = null;

    }//costruttore

    public Node(Node prev,T element,Node link){

        this.prev = prev;
        this.element=element;
        this.link = link;

    }//costruttore

    public Node getPrev(){

        return prev;

    }

    public T getElement() {
        return element;
    }

    public Node getLink() {
        return link;
    }

    public void setPrev(Node prev){

        this.prev = prev;

    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}
