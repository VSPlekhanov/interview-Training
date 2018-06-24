package homework2;


public class LinkedtStack<T> {
    private Node head;
    private int size;
    private boolean isEmpty = true;

    public void push(T value){
        head = new Node(head, value);
        size++;
        if (isEmpty){
            isEmpty = false;
        }
    }

    public T pop(){
        if (head == null) {
            return null;
        }
        T value = head.value;
        head = head.prev;
        size--;
        if (size == 0){
            isEmpty = true;
        }
        return value;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    class Node{
        Node prev;
        T value;

        Node(Node prev, T value) {
            this.prev = prev;
            this.value = value;
        }
    }
}
