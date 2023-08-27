package advance.linkedlist;

public class Play {

    private Node head;
    private Node tail;

    private class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
        }

        public String toString() {
            return "Node: " + data;
        }
    }

    public Play() {
    }

    // Insert first element
    public void insertFirstDll(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        newNode.prev = null;

        if (head != null)
            head.prev = newNode;

        head = newNode;
    }

    public void displayDll() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Add to the end of the list
    public void insertLastDll(int value) {
        Node newNode = new Node(value);
        Node lastNode = head;
        newNode.next = null;
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        newNode.prev = lastNode;
    }

    // Get element at an index
    public Node getIndex(int index) {
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Find a value in a list
    public Node findNodeByValue(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // get the size of the list
    public int sizeDll() {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void insertAtIndex(int after, int value) {
        Node prevNode = findNodeByValue(after);
        if (prevNode == null) {
            System.out.println("Node not found");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    // Return -1 if the head is null
    public int deleteFirst() {
        if (head == null)
            return -1;

        int data = head.data;
        head = head.next;
        head.prev = null;
        return data;
    }

    public int deleteLastNode(){
        // data
        // find lastnode
        // move the lastnode back
        // set the next of the lastnode to null
        if(head == null){
            return -1;
        }
        if (head.next == null){
            int data = head.data;
            head = null;
            return data;
        }
        Node lastNode = head;
        while (lastNode.next != null){
            lastNode = lastNode.next;
        }
        int data = lastNode.data;
        lastNode.prev.next = null;
        return data;
    }
}