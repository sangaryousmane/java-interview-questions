package advance.crackingCodingInterview.linkedList.general;

import advance.crackingCodingInterview.ListNode;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class KthToLast {


    // TC O(n), SC O(1)
    public ListNode kthToLast(ListNode head, int kth){
        if(head == null || kth < 1) return null;

        ListNode fast = head;
        ListNode slow = head;

        for (int i=0; i < kth; i++){
            if (fast == null) return null;

            fast = fast.next;
        }

        // Move both pointers until the fast hit the last element at which time
        // the slow will hit the second to last element.

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
