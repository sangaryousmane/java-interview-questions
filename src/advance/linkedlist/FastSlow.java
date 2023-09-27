package advance.linkedlist;

public class FastSlow {
    private Node head;


    private class Node {
        private Node next;
        private int data;

        public Node(int data, Node next) {
            this.next = next;
            this.data = data;
        }

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Data: " + this.data;
        }
    }



    // Add a node
    public void addNode(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // display nodes
    public void displayNodes() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


    // Find if there is a cycle or loop in the linked list
    public int check_cycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return 1;
        }
        return 0;
    }


    // Delete the last element
    public int deleteLastElement(){
        if (this.head == null)
            return -1;

        Node last = head;
        int size = 1;
        while (last.next != null){
            size++;
            last = last.next;
        }
        Node nextToLast = getNode(size - 2);
        int data = last.data;
        nextToLast.next = null;
        return data;
    }



    // Delete first element
    public int deleteFirstElement(){
        if (this.head == null)
            return -1;

        Node temp = head;
        head = head.next;
        return temp.data;
    }

    // Add element at a given index
    public void addAtIndex(int value, int index){
        if (index == 0 )
            addNode(value);

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(value, temp.next);
        temp.next = newNode;
    }

    public Node findNodeByValue(int value){
        Node temp = head;
        while (temp != null){
            if (temp.data == value)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Insert last element in the linked list
    public void addLast(int data){
        Node newNode = new Node(data);
        newNode.next = null;

        if (this.head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    private Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }




    // Insert a new number in a sorted SL
    public void insertNumberInSortedLL(Node newNode){

        Node temp;
        if (head == null || head.data >= newNode.data){
            newNode.next = head;
            head = newNode;
        }
        temp = head;
        while (temp.next != null && temp.next.data < newNode.data){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        FastSlow fastSlow = new FastSlow();
        fastSlow.addNode(50);
        fastSlow.addNode(40);
        fastSlow.addNode(30);
        fastSlow.addNode(20);
        fastSlow.addNode(10);
        fastSlow.displayNodes();
        System.out.println("Deleted last: " + fastSlow.deleteLastElement());
        fastSlow.displayNodes();
        System.out.println("Delete first: " + fastSlow.deleteFirstElement());
        fastSlow.addAtIndex(50, 2);
        fastSlow.displayNodes();
        System.out.println(fastSlow.findNodeByValue(50));
        fastSlow.addLast(90);
        fastSlow.displayNodes();
    }
}
