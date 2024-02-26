package advance.linkedlist;

public class Play {

    private class ListNode {
        private ListNode next;
        private int value;

        public ListNode(int value, ListNode node) {
            this.value = value;
            this.next = node;
        }

        public ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value = " + value;
        }
    }

    private ListNode head;

    public void addFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = null;

        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Get node given index
    public ListNode getNode(int index) {
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Find node given the value
    public ListNode findNode(int data) {
        ListNode node = head;
        while (node != null) {
            if (node.value == data)
                return node;
            node = node.next;
        }
        return null;
    }

    public int getLength() {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public int deleteFirst() {
        if (head == null) return -1;

        int data = head.value;
        head = head.next;
        return data;
    }

    public int deleteLast(){
        if (head == null) return -1;
//        if (head.next == null){
//            deleteFirst();
//            return head.value;
//        }
        ListNode last=head;
        int size = 1;
        while (last.next != null){
            size++;
            last = last.next;
        }
        ListNode secondToLast=head;
        for(int i = 0; i < size - 2; i++){
            secondToLast = secondToLast.next;
        }
        int data= last.value;
        secondToLast.next = null;
        return data;
    }

    public boolean detectCycle(){
        ListNode turtle=head;
        ListNode hare = head;

        while (hare != null && hare.next != null){
            turtle = turtle.next; // single step
            hare = hare.next.next; // Double step
            if (turtle == hare)
                return true;

        }
        return false;
    }

    public void displayNodes() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        Play p = new Play();
        p.addFirst(5);
        p.addFirst(4);
        p.displayNodes();
        p.addLast(15);
//        p.addLast(13);
        p.displayNodes();
        p.deleteFirst();
        p.displayNodes();
        p.deleteLast();
        p.displayNodes();
        p.deleteLast();
        p.displayNodes();
        p.deleteLast();
        p.displayNodes();



//        System.out.println("The length is: " + p.getLength());
    }
}