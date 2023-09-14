package advance.linkedlist;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Value: " + data;
        }
    }

    // Add element at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add element at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    // Find a node by given index
    public Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // find node given value
    public Node findByValue(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Delete first element in a list
    public int deleteFirst() {
        if (head == null)
            return -1;

        int data = head.data;
        head = head.next;
        return data;
    }

    // Delete last element
    public int deleteLast() {
        if (head == null)
            return -1;

        int size = 1;
        Node lastNode = head;
        while (lastNode.next != null) {
            size += 1;
            lastNode = lastNode.next;
        }
        Node secondToLast = getNode(size - 2); // second to last element
        int data = lastNode.data;
        secondToLast.next = null;
        return data;
    }

    // Add at an index
    public void addAtIndex(int value, int index) {
        if (index == 0) {
            addFirst(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = new Node(value, temp.next);
    }

    // Get length
    public int getLength() {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    // Delete element at an index
    public int deleteAtIndex(int index) {
        if (index == 0) {
            deleteFirst();
            return head.data;
        }
        Node previousNode = getNode(index - 1);
        int data = previousNode.next.data;
        previousNode.next = previousNode.next.next;
        return data;
    }

    public void displayList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Find a cycle in a linked list
    public boolean isCycle() {
        Node turtle = head;
        Node hare = head;

        while (hare != null && hare.next != null) {
            turtle = turtle.next; // move one step at a time
            hare = hare.next.next; // two steps at a time
            if (hare == turtle)
                return true;
        }
        return false;
    }

    // Find the length of the cycle
    public int lengthOfCycle(Node head){
        Node turtle = head;
        Node hare = head;

        while (hare != null && hare.next != null) {
            turtle = turtle.next; // move one step at a time
            hare = hare.next.next; // two steps at a time
            if (hare == turtle) {
                int length = 0;
                Node temp = turtle;
                do {
                    temp = temp.next;
                    length++;
                }while (temp != turtle);
                return length;
            }
        }
        return 0;
    }

    public Node detectCycle(Node head){
        Node turtle = head;
        Node hare = head;
        int length = 0;

        while (hare != null && hare.next != null) {
            turtle = turtle.next; // move one step at a time
            hare = hare.next.next; // two steps at a time
            if (hare == turtle) {
                Node temp = turtle;
                do {
                    temp = temp.next;
                    length++;
                }while (temp != turtle);
                break;
            }
        }

        if (length == 0)
            return null;

        // find the cycle's beginning
        Node f = head;
        Node s = head;
        for (int i = 0; i < length; i++){
            s = s.next;
        }

        // Keep moving them forward until they meet
        while (f != s){
            f = f.next;
            s = s.next;
        }
        return s;
    }

    // Create your own cycle
    public void createCycle(int index) {
        Node temp = head;
        Node creator = null;
        int i = 0;
        while (temp.next != null) {
            if (i == index)
                creator = temp;
            temp = temp.next;
            i++;
        }
        temp.next = creator;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addFirst(3);
        sll.addFirst(11);
        sll.addLast(300);

        sll.head.next.next.next = sll.head.next;

        int cycleLength = sll.lengthOfCycle(sll.head);
        System.out.println("Length: " + cycleLength);

    }
}