package homework2;

import java.util.Random;

public class CyclicListExercise {

    static boolean isCyclic(CyclicList list) {
        CyclicList.Node currentNode = list.head();
        for (int i = 0; i < list.size(); i++) {
            currentNode = list.next(currentNode);
        }
        return list.next(currentNode) != null;
    }

    static class CyclicList<T> {
        Node head;
        int size;

        /**
         * Generate list with cycle in random place, or without cicle
         */
        public CyclicList(int size, boolean withCycle) {
            this.size = size;
            head = new Node(null, null);
            Node currentNode = head;
            int randomNodeIndex = new Random().nextInt(size - 1) + 1;
            Node randomNode = null;
            for (int i = 0; i < size; i++) {
                currentNode.next = new Node(null, null);
                currentNode = currentNode.next;

                if (withCycle && i == randomNodeIndex) {
                    randomNode = currentNode;
                }
            }
            currentNode.next = randomNode;
        }

        Node head() {
            return head;
        }

        Node next(Node node) {
            return node.next;
        }

        T value() {
            return head.value;
        }

        int size() {
            return size;
        }

        class Node {
            Node next;
            T value;

            public Node(Node next, T value) {
                this.next = next;
                this.value = value;
            }
        }
    }
}
