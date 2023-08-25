//package advance.linkedlist;
//
//public class DoublyLinkedList {
//    private Node head;
//
//
//
//    private class Node{
//        private int val;
//        private Node next;
//        private Node prev;
//
//        public Node(int val) {
//            this.val = val;
//        }
//
//        public Node() {
//        }
//    }
//
//    public void insertFirst(int val){
//        Node node=new Node(val);
//        node.next = head;
//        node.prev = null;
//
//        if (head != null)
//            head.prev = node;
//        head = node;
//    }
//
//    public void displayForward(){
//        Node temp = head;
//
//        while (temp != null){
//            System.out.print(temp.val + " -> ");
//            temp = temp.next;
//        }
//        System.out.println("END!");
//    }
//
//    public void displayReverse(){
//        Node lastNode = null;
//        Node temp = head;
//
//        System.out.println("Forward: ");
//        while (temp != null){
//            System.out.print(temp.val + " -> ");
//            lastNode = temp;
//            temp = temp.next;
//        }
//
//        System.out.println("\nBackward: ");
//        while (lastNode != null){
//            System.out.print(lastNode.val + " -> ");
//            lastNode = lastNode.prev;
//        }
//        System.out.println("START");
//    }
//
//}
