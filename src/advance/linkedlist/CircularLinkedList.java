package advance.linkedlist;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    private class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    // Insert first element in a circular linked list
    public void add(int data){
        Node newNode=new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    // O(n)
    public void display(){
        Node temp = head;
        if (head != null){
            do{
                System.out.print(temp.data + " -> ");
               if (temp.next != null)
                   temp = temp.next;
            } while (temp != head);
        }
        System.out.println("HEAD");
    }

}
