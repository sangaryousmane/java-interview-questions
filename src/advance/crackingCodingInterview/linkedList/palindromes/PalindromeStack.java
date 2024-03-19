package advance.crackingCodingInterview.linkedList.palindromes;

import advance.crackingCodingInterview.ListNode;

import java.util.Stack;

public class PalindromeStack {

    public ListNode head;

    public boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        Stack<Integer> container= new Stack<>();

        while (fast != null && fast.next != null){
            container.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // Has Odd number of elements
        if (fast != null){
            slow = slow.next;
        }

        while (slow != null){
            int top = container.pop();

            // If values are different, it is not a palindrome
            if (top != slow.data){
                return false;
            }
            slow = slow.next;
        }
        return true;
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
