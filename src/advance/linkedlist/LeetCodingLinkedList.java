package advance.linkedlist;

import java.util.List;

public class LeetCodingLinkedList {
    private ListNode head;

    private class ListNode {
        private int value;
        private ListNode next;


        public ListNode(int value) {
            this.value = value;
        }

        public ListNode() {
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    // Add element at begining
    public void add(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    // Display elements
    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Remove duplicates in a linkedlist
    // https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
    public void duplicates() {

        ListNode node = head;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    // Add node as last
    private void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode = temp;
    }

    // Check for a cycle in a linked list
    public boolean checkCycle() {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true; // Meaning there is a cycle or loop
        }
        return false; // there is no cycle or loop
    }

    // Find the length of the cycle
    public int lengthOfTheCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow;
                int size = 0;
                do {
                    temp = temp.next;
                    size++;
                } while (temp != slow);
                return size;
            }
        }
        return 0;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    // Find the length of the cycle
    // Move the slow pointer ahead by length of the cycle times
    // Move slow and fast pointer by one, and they'll meet at start
    public ListNode detectPointInCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int size = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode temp = slow;
                do{
                    temp = temp.next;
                    size++;
                }while (temp != slow);
                break;
            }
        }

        if (size == 0){
            return null;
        }

        // Find the start node
        ListNode f = head;
        ListNode s = head;
        for (int i = 0; i < size; i++) {
            s = s.next;
        }

        // Keep moving them forward until they meet
        while (f != s){
            f = f.next;
            s = s.next;
        }
        return s;
    }

    public static void main(String[] args) {
        LeetCodingLinkedList list = new LeetCodingLinkedList();
        list.insertAtEnd(-4);
        list.insertAtEnd(0);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.display();

        list.head.next.next.next = list.head.next;
        System.out.println("Is there a cycle: " + list.checkCycle());
        int cycleLength = list.lengthOfTheCycle(list.head);
        ListNode in = list.detectPointInCycle(list.head);
        System.out.println("Node at cycle: "+ in.value);
        System.out.println("Length of the cycle: " + cycleLength);

    }
}
