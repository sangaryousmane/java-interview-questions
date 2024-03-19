package advance.crackingCodingInterview.linkedList.general;

import advance.crackingCodingInterview.ListNode;
import advance.linkedlist.LeetCodingLinkedList;

import java.util.List;

public class DeleteMiddle {

    public ListNode deleteMiddle(ListNode head){
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next.next;


        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow= slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
