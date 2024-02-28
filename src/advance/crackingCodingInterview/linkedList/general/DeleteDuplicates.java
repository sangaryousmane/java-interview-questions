package advance.crackingCodingInterview.linkedList.palindromes;

import advance.crackingCodingInterview.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicates {

    // TC and SC is: O(n)
    public void deleteDup(ListNode node) {
        Set<Integer> set=new HashSet<>();
        ListNode previousNode=null;

        while (node != null){
            if (set.contains(node.data)){
                previousNode.next = node.next;
            }
            else {
                set.add(node.data);
                previousNode = node;
            }
            node = node.next;
        }
    }
}
