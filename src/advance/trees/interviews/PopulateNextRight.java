package advance.trees.interviews;

//     // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
public class PopulateNextRight {

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public Node connect(Node root) {

        if (root == null) return null;
        Node leftMostNode = root;

        while (leftMostNode.left != null) {
            Node current = leftMostNode;
            while (current != null) {
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMostNode = leftMostNode.left;
        }
        return root;
    }

}
