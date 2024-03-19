package advance.crackingCodingInterview.linkedList.palindromes;
// Check if the linked list is a palindrome using the reverse and compare approach

import advance.crackingCodingInterview.ListNode;

public class PalindromeRC {

    public ListNode head;

    public boolean isPalindrome(ListNode head) {
        ListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    static boolean isEqual(ListNode firstNode, ListNode secondNode) {
        while (firstNode != null && secondNode != null) {
            if (firstNode.data != secondNode.data) {
                return false;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return firstNode == null && secondNode == null;
    }

    public ListNode reverseAndClone(ListNode node) {
        this.head = null;
        while (node != null) {
            ListNode newNode = new ListNode(node.data);
            newNode.next = head;
            head = newNode;
            node = node.next;
        }
        return head;
    }

    public void add(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


}
