package advance.linkedlist;

public class LeetCodingLinkedList {
    private ListNode head;
    private int tail;
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

    // Remove duplicates in a linkedlist
    public void duplicates() {

        ListNode node = head;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last = node;
        last.next = null;
    }


    public static void main(String[] args) {
        SLL sll = new SLL();
        LeetCodingLinkedList listNode = new LeetCodingLinkedList();
        sll.add(2);
        sll.add(2);
        sll.add(3);
        sll.add(3);
        sll.add(5);
        sll.displayListContent();
        listNode.duplicates();
        sll.displayListContent();

    }
}
