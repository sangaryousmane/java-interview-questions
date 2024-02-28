package advance.crackingCodingInterview;
// Check if the linked list is a palindrome

public class Palindrome {


    public boolean isPalindrome(ListNode head) {
        return false;
    }

    static boolean isEqual(ListNode firstNode, ListNode secondNode){
        while (firstNode != null && secondNode != null){
            if (firstNode.data != secondNode.data){
                return false;
            }
            firstNode = firstNode.next;
            secondNode  = secondNode.next;
        }
        return firstNode == null && secondNode == null;
    }

    public ListNode reverseAndClone(ListNode node){
        
    }


}
