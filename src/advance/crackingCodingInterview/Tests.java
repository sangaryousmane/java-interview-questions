package advance.crackingCodingInterview;

import advance.crackingCodingInterview.linkedList.general.DeleteDuplicates;
import advance.crackingCodingInterview.linkedList.general.DeleteMiddle;
import advance.crackingCodingInterview.linkedList.general.KthToLast;
import advance.crackingCodingInterview.linkedList.general.PartitionAroundX;
import advance.crackingCodingInterview.linkedList.palindromes.PalindromeStack;

public class Tests {


    public static void main(String[] args) {
        // Create a linked list: 1 -> 3 -> 5 -> 7 -> 9 -> 11 -> 13
        ListNode head = new ListNode(1);
        PartitionAroundX kthToLast = new PartitionAroundX();
        kthToLast.add(3);
        kthToLast.add(5);
        kthToLast.add(8);
        kthToLast.add(5);
        kthToLast.add(10);
        kthToLast.add(2);
        kthToLast.add(1);

        // Test for 2nd to last
        System.out.println(kthToLast.partition(head, 5));
        kthToLast.print();

        // Test for 4th to last
//        ListNode result2 = kthToLast.kthToLast(head, 6);
//        System.out.println("6th to last: " + result2.data);
    }
}
