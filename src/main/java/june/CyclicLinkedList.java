package june;

public class CyclicLinkedList<T> {
    private Node head;

    private int length = 0;

    public void add(T value){
        if (length++ == 0){
            head = new Node(value);
            head.prev = head;
            head.next = head;
        }else {
            Node newNode = new Node(head, head.prev, value);
            head.prev.next = newNode;
            head.prev = newNode;
        }
    }

    public T get(int index){
        return search(index).value;
    }

    private Node search(int index){
        if (index < 0 || index >= length) throw new IllegalArgumentException("wrong index: " + index);
        Node currentNode = head;
        if (index <= length >> 1) {
            for (int i = 1; i <= index; i++) {
                currentNode = currentNode.next;
            }
        }else {
            for (int i = length; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    public T delete(int index){
        if (length == 0) throw new UnsupportedOperationException("list is already empty");
        Node currentNode = search(index);
        T value = currentNode.value;
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        length--;
        if (index == 0){
            head = head.next;
        }
        return value;
    }

    public T getHead(){
        return head.value;
    }

    public T getTail(){
        return head.prev.value;
    }

    public int getLength(){
        return length;
    }

    class Node{
        Node next;
        Node prev;
        T value;

        Node(Node next, Node prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        Node(T value) {
            this.value = value;
        }
    }

}
