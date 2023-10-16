package advance;

public class BinarySearchTree {

    private class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
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

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int value){
        root = insert(value, root);
        
    }

    // Insert a value helper
    private Node insert(int value, Node node){
        if (node == null) {
            this.root = new Node(value);
            return node;
        }

        if (value < node.value)
            node.left = insert(value, node.left);

        if (value > node.value)
            node.right = insert(value, node.right);

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }
    public void display(){
        display(root, "Root Node");
    }

    private void display(Node node, String details) {
        if (node == null)
            return;
        System.out.println(details + node.getValue());

        display(node.left, "Left child of "+ node.getValue() + " : ");
        display(node.right, "Right child of "+ node.getValue() + " : ");
    }
}
