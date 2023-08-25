package advance.linkedlist;

public class DLL {
    private Node tail;
    private Node head;
    private int size;

    public DLL(){
        this.size = 0;
    }

    private class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(){}

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
    public void add(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;
        if (head != null)
            head.prev = newNode;
        head = newNode;
        size++;
    }

    // Print the doubly linked list
    public void display(){
        Node temp = head;

        System.out.println("Printing in forward...");
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Display in reverse of DLL
    public void displayRev(){
        Node temp = head;
        Node lastItem = null;

        while (temp != null){
            lastItem = temp;
            temp = temp.next;
        }

        System.out.println("Printing in reverse....");
        while (lastItem != null){
            System.out.print(lastItem.data + " -> ");
            lastItem = lastItem.prev;
        }
        System.out.println("END");
    }
}
