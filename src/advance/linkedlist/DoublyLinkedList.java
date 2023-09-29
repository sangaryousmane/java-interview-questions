package advance.linkedlist;

public class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {
    }

    public class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }
    }

    // Add element to the DLL
    public void addFirst(int data) {
        Node newNode=new Node(data);
        newNode.prev = null;
        newNode.next = head;

        if (head != null){
            head.prev = newNode;
        }
        head = newNode;
    }

    // Add last
    public void addLast(int data) {
        Node newNode=new Node(data);
        newNode.next = null;

        if (head == null){
            newNode.prev = null;
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        temp.prev = newNode;
    }

    // Get an element at a specific index
    public Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Delete element at the beginning
    public int delete() {
        if (head == null)
            return -1;

        int data = head.data;
        head = head.next;
        if (head != null)
            head.prev = null;
        return data;
    }

    // Delete element at the end
    public int deleteAtEnd(){

        if (head == null)
            return -1;

        int value;
        if (head.next == null){
            value = head.data;
            head = null;
        }else{
            Node temp = head;
            while (temp.next.next != null){
                temp = temp.next;
            }
            value = temp.next.data;
            temp.next = null;

        }
        return value;
    }
    // Display Elements
    public void display() {
        Node temp = head;
        Node rev = head;
        System.out.println("Forward starts ");
        while (temp != null) {
            rev = temp;
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
//        System.out.println("Reverse starts ");
//        while (rev != null) {
//            System.out.print(rev.data + " -> ");
//            rev = rev.prev;
//        }
//        System.out.println("END");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(50);
        dll.addFirst(30);
        dll.addFirst(20);
        dll.display();
        dll.addLast(100);
        dll.display();
        dll.addFirst(4);
        dll.display();
        dll.delete();
        dll.display();


    }

}