package advance.trees;

public class BinarySearchTree {

    private class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    private Node root;

    public BinarySearchTree() {
    }

    // Find the node's height
    public int height(Node node) {
        if (node == null)
            return -1;
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insert(value, root);

    }

    // Insert a value helper
    private Node insert(int value, Node node) {
        if (node == null) {
            this.root = new Node(value);
            return node;
        }

        // Insert on the left if the value is less than the root
        if (value < node.value)
            node.left = insert(value, node.left);

        // Insert on the right if the value is greater than the root
        if (value > node.value)
            node.right = insert(value, node.right);

        // Find the height of the left and right node
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void inOrderTraversal() {
        inOrderTraversal(this.root);
    }

    public void inOrderTraversal(Node node) {
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.println(node.value + "->");
        inOrderTraversal(node.right);
    }

    /*
    Case 1: In the first case, the node to be deleted is the leaf node.
    In such a case, simply delete the node from the tree.

    Case 2: In the second case, the node to be deleted has a single child node.
    In such a case follow the steps below:
          a. Replace that node with its child node.
          b. Remove the child node from its original position.

    Case 3: In the third case, the node to be deleted has two children.
    In such a case follow the steps below:
          a. Get the inorder successor of that node.
          b. Replace the node with the inorder successor.
          c. Remove the inorder successor from its original position.
     */
    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return node;
        }
        if (value < node.getValue())
            node.left = delete(node.left, value);
        else if (value > node.getValue())
            node.right = delete(node.right, value);
        else {
            // If the node is with only one child or no child
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
        }
        // If the node has two children
        // Place the inorder successor in position of the node to be deleted
        node.value = minValue(node.right);

        // Delete the inorder successor
        node.right = delete(node.right, node.value);
        return node;
    }

    private int minValue(Node node) {
        int minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }

    public boolean balanced() {
        return balanced(this.root);
    }

    private boolean balanced(Node node) {
        if (node == null)
            return true;

        return Math.abs(height(node.left) - height(node.right)) <= 1
                && balanced(node.left) && balanced(node.right);
    }

    public void display() {
        display(root, "Root Node");
    }

    private void display(Node node, String details) {
        if (node == null)
            return;
        System.out.println(details + node.getValue());

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inOrderTraversal();

        System.out.println("\n\nAfter deleting 10");
        tree.delete(10);
        System.out.print("Inorder traversal: ");
        tree.inOrderTraversal();
    }


}
