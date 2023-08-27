package advance.linkedlist;

public class DLL {
    private Node head;

    private class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }


    // Insert at the beginning of a doubly linked list
    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;
        if (head != null)
            head.prev = newNode;
        head = newNode;
    }

    // Print the doubly linked list
    public void display() {
        Node temp = head;

        System.out.println("Printing in forward...");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Display in reverse of DLL
    public void displayRev() {
        Node temp = head;
        Node lastItem = null;

        while (temp != null) {
            lastItem = temp;
            temp = temp.next;
        }

        System.out.println("Printing in reverse....");
        while (lastItem != null) {
            System.out.print(lastItem.data + " -> ");
            lastItem = lastItem.prev;
        }
        System.out.println("END");
    }

    // Insert a value at the first index
    public void addEnd(int data) {
        Node newNode = new Node(data);
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

    // Find a node at a particular value
    public Node findNodeGivenValue(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Insert after a particular value/index
    public void addAtIndex(int after, int value){
        Node prevNode = findNodeGivenValue(after);

        if (prevNode == null){
            System.out.println("Node not found");
            return;
        }
        Node newNode = new Node(value);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if(newNode.next != null){
            newNode.next.prev = newNode;
        }
    }

    public int sumOfDll(){
       Node temp = head;
       int sumOfDll = 0;
       while (temp != null){
           sumOfDll += temp.data;
           temp = temp.next;
       }
       return sumOfDll;
    }

}
