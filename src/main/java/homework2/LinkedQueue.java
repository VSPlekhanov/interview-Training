package homework2;

public class LinkedQueue<T> {
    private Node head;
    private Node tail;
    private int size;
    private boolean isEmpty = true;

    public void push(T value){
        if (head == null){
            head = new Node(null, value);
            tail = head;
        } else {
            tail.next = new Node(null, value);
            tail = tail.next;
        }
        if (isEmpty){
            isEmpty = false;
        }
        size++;
    }

    public T pop(){
        if (isEmpty){
            return null;
        }
        T value = head.value;
        head = head.next;
        if (head == null){
            isEmpty = true;
        }
        size--;
        return value;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    class Node {
        Node next;
        T value;

        Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }
    }
}
