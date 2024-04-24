public class Node<T> {

    private T element;
    private Node link;

    public Node(T element){

        this.element=element;
        link = null;

    }//costruttore

    public T getElement() {
        return element;
    }

    public Node getLink() {
        return link;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}
