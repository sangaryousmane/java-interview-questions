package advance.linkedlist;

public class LeetCodingLinkedList {
    private ListNode head;

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

        @Override
        public String toString() {
            return "value: " + value;
        }
    }

    // Add element at begining
    public void add(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    // Display elements
    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Remove duplicates in a linkedlist
    // https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
    public void duplicates(ListNode head) {
        if (head == null)
            return;

        ListNode node = head;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public ListNode removeNthNode(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        // Iterate fast time n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // check an edge case whether fast is null
        if (fast == null) {
            return head.next;
        }
        // keep shifting the hare and turtle until you reach the target
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    // Add node as last
    private void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode = temp;
    }

    // Check for a cycle in a linked list
    public boolean checkCycle() {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true; // Meaning there is a cycle or loop
        }
        return false; // there is no cycle or loop
    }

    // Find the length of the cycle
    public int lengthOfTheCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow;
                int size = 0;
                do {
                    temp = temp.next;
                    size++;
                } while (temp != slow);
                return size;
            }
        }
        return 0;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    // Find the length of the cycle
    // Move the slow pointer ahead by length of the cycle times
    // Move slow and fast pointer by one, and they'll meet at start
    public ListNode detectPointInCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int size = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode temp = slow;
                do {
                    temp = temp.next;
                    size++;
                } while (temp != slow);
                break;
            }
        }

        if (size == 0) {
            return null;
        }

        // Find the start node
        ListNode f = head;
        ListNode s = head;
        for (int i = 0; i < size; i++) {
            s = s.next;
        }

        // Keep moving them forward until they meet
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    // https://leetcode.com/problems/happy-number/
    // Check if a number is happy
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = squareOfDigits(n);
            fast = squareOfDigits(squareOfDigits(n));
        } while (slow != fast);

        if (slow == 1)
            return true;
        return false;
    }

    // Find square of digits
    public int squareOfDigits(int n) {
        int squareOfDigits = 0;
        while (n > 0) {
            int remainder = n % 10;
            squareOfDigits += remainder * remainder;
            n /= 10;
        }
        return squareOfDigits;
    }

    // Find the middle node of the linked list
    public ListNode findMiddleOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Iterative or in-place reversal
    // https://leetcode.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = null;

        while (slow != null) {
            slow.next = prev;
            prev = slow;
            slow = fast;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return prev;
    }

    // Reverse linked list using recursion
    public void reverse(ListNode head) {
        if (head == null)
            return;

        ListNode lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        if (head == lastNode) {
            head = lastNode;
            return;
        }

        reverse(head.next);
        lastNode.next = head;
        lastNode = head;
        lastNode.next = null;
    }

    // Find the palindrome of a linked list
    // https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = findMiddleOfList(head);
        ListNode headSecond = reverseList(middleNode);
        ListNode reReverseList = headSecond;

        while (head != null && headSecond != null) {
            if (head.value != headSecond.value)
                break;
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(reReverseList); // Rereversed
        return head == null || headSecond == null;
    }

    // Delete the middle element in the list
    // https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // Let the next of the middle element points to the one step after
        slow.next = slow.next.next;
        return head;
    }


    // https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
    public int convertBinaryToDecimal(ListNode head) {
        ListNode temp = head;
        int decimal = 0;
        while (temp != null) {
            decimal = decimal * 2 + temp.value;
            temp = temp.next;
        }
        return decimal;
    }

    public static void main(String[] args) {
        LeetCodingLinkedList list = new LeetCodingLinkedList();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(1);
        list.display();
//        list.deleteMiddle(list.head);
        list.display();
        System.out.println("Decimal: " + list.convertBinaryToDecimal(list.head));
//        list.insertAtEnd(3);

//        list.head.next.next.next = list.head.next;
//        System.out.println("Is there a cycle: " + list.checkCycle());
//        int cycleLength = list.lengthOfTheCycle(list.head);
//        ListNode in = list.detectPointInCycle(list.head);
//        System.out.println("Node at cycle: "+ in.value);
//        System.out.println("Length of the cycle: " + cycleLength);

//        list.display();
//        System.out.println("Middle: " + list.findMiddleOfList(list.head));
    }
}
