package advance.linkedlist;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return " value = " + value;
        }
    }

    // insert an element in a linked list
    public void insertFirstElement(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        // Check if the end element(tail) is null
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // Insert an element at the end of the linked list
    public void insertLastElement(int value) {
        if (tail == null) {
            insertFirstElement(value);
            return; // Don't perform anything once the tail is null
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtIndex(int value, int index) {

        if (index == 0) {
            insertFirstElement(value);
            return;
        }
        if (index == size) {
            insertLastElement(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(value, temp.next);
        temp.next = newNode;
        size++;
    }

    // Get a value at an index
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int getListLength() {
        return size;
    }

    public boolean isEmpty() {
        return tail == null && head == null;
    }

    public int deleteFirst(){
        int value = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return value;
    }
    public int deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        return value;
    }

    // Delete a node at a given index
    public int deleteAtIndex(int index){
        if (index==0)
            return deleteFirst();

        if (index == size-1)
            return deleteLast();

        Node prev = get(index - 1);
        int value = prev.next.value;
        prev.next = prev.next.next; // 5 10 3
        return value;
    }

    // Find a node and return it given the value
    public Node findNode(int value){
        Node temp = head;
        while (temp != null){
            if (temp.value == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    // Display the content of the linked list
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END!");
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
