public class Node<T>{
    private T value;
    public Node next;
    public Node previous;

    public Node(T value, Node next, Node previos) {
        this.value = value;
        this.next = next;
        this.previous = previos;
    }
    public Node(T value) {
        this(value, null, null);
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s",value);
    }
}
