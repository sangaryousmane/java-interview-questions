package advance.crackingCodingInterview.linkedList.general;

import advance.crackingCodingInterview.ListNode;

/**
 * Write a code to partition a linked list around a value x, such that
 * all nodes less than x comes before all nodes greater than or equal to x. If x is contained within the list,
 * the vales of x only need to be after the elements less than x. The partition element x can appear anywhere in the "right
 * partition"; it doesn't need to appear btw the left and right partitions.
 */
public class PartitionAroundX {
    ListNode  head;

    public ListNode partition(ListNode node, int X) {
        ListNode head = node;
        ListNode tail = node;

        while (node != null){
            ListNode nextNode = node.next;

            if(node.data < X){
                // Insert it at the head
                node.next = head;
                head = node;
            }else {
                node.next = tail;
                tail = node;
            }

            node = nextNode;
        }
        return head;
    }


    public ListNode partition2(ListNode node, int X) {
        ListNode beforeHead = new ListNode(0); // Head of the list with nodes < X
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0); // Head of the list with nodes >= X
        ListNode after = afterHead;

        while (node != null) {
            if (node.data < X) {
                before.next = node;
                before = before.next;
            } else {
                after.next = node;
                after = after.next;
            }
            node = node.next;
        }

        after.next = null; // Set the end of the after list
        before.next = afterHead.next; // Join the two lists

        return beforeHead.next; // Return the head of the partitioned list
    }
    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void add(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }
}
