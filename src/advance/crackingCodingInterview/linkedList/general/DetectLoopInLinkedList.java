package advance.crackingCodingInterview.linkedList.general;

import advance.crackingCodingInterview.ListNode;

//
public class DetectLoopInLinkedList {


    public ListNode findLoopInLinkedList(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        // Check if there is no meeting point, and therefore there will be no loop
        if (fast == null || fast.next == null) return null;

        // Move the slow to the head and keep the fast at the meeting point
        // If they keep going, they'll meet at the loop start.
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
