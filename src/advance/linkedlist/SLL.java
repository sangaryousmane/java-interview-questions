package advance.linkedlist;

public class SLL {
    private Node head;
    private Node tail;
    private int size;

    public SLL() {
        this.size = 0;
    }

    private class Node {
        private Node next;
        private int data;


        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }

        @Override
        public String toString() {
            return "data = " + data;
        }
    }

    // Insert an item at the beginning of the list
    // O(1)
    public void add(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        // Check whether the tail is null and make the head
        // and tail points to the same element
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // Add an element at the end of the list
    // O(1) or O(n) if iteration is required
    public void addEnd(int value) {
        if (tail == null) {
            add(value);
            return;
        }

        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        size++;
    }


    // Insert at an index - O(n)
    public void addAtIndex(int value, int index) {
        if (index == 0) {
            add(value);
            return;
        }
        if (index == size) {
            addEnd(value);
            return;
        }

        // Iterate through the linked list from index 1 to the last
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(value, temp.next);
        temp.next = newNode;
        size++;
    }

    // Return the length of the list
    public int listLength() {
        return size;
    }

    // Get a node at a particular index
    // O(n) where n is the size of the list
    public Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return tail == null && head == null;
    }

    // Delete a node's value at the beginning of the linked list
    // O(1) if conditional is not required
    public int delete() {
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    // Delete the last value of the list
    // O(n)
    public int deleteLast(){
        if (size <= 1)
            return delete();

        // Get the index of the list and perform deletion
        Node secondToLast = getNode(size - 2); // second to last item
        int value = tail.data;
        tail  = secondToLast;
        tail.next = null;
        return value;
    }

    // Delete a node's value based on index
    // O(n)
    public int deleteByIndex(int index){
        if (index == 0)
            return delete();
        if (index == (size - 1))
            return deleteLast();

        Node prev = getNode(index - 1); // the previous node
        int value = prev.next.data;
        prev.next = prev.next.next;
        return value;
    }
    // Find a node based on the value in a linked list
    // O(n)
    public Node findNode(int value) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Display content of the list
    public void displayListContent() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Insert a node in a sorted singly linked list
    public Node insertSorted(int data){
        Node newNode = new Node(data);
        Node temp = head;

        if (temp == null || temp.data >= newNode.data){
            newNode.next = temp;
            head = newNode;
            return newNode;
        }
        while (temp.next.data < newNode.data){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return newNode;
    }


    public boolean isCycle(){
        Node turtle = head;
        Node hare = head;

        while (hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare)
                return true;
        }
        return false;
    }
}
