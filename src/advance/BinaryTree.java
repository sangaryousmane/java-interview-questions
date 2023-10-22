package advance;

import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryTree {
    Node root;

    // Pre order traversal
    public void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " -> "); // First, traverse the root
        preOrder(node.left); // Second, the left
        preOrder(node.right); // Lastly, the right
    }

    // Inorder traversal Left, Root, Right
    public void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left); // Left node
        System.out.print(node.data + " -> "); // The root node
        inOrder(node.right); // Right
    }

    // Post Order traversal: Left, Right, Root
    public void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left); // Left node
        postOrder(node.right); // Right node
        System.out.print(node.data + " -> ");
    }

    // Populate the tree
    public void populate(Scanner scanner) {
        System.out.println("Enter the root node");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }


    public void populate(Scanner scanner, Node node) {
        System.out.println("Do you wanna insert the left of: " + node.data);

        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the left of : " + node.data);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left); // Insert to left
        }

        System.out.println("Do you wanna insert the right of: " + node.data);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the right of: " + node.data);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right); // Insert to right
        }
    }


    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null)
            return;

        System.out.println(indent + node.data);

        if (!(node.left == null && node.right == null)){
            display(node.left, indent + "├──");
            display(node.right, indent + "└──");
        }else if(node.left != null){
            display(node.left, indent + "└──");
        }else if (node.right != null){
            display(node.right, indent + "└──");
        }
    }

    public static void main(String[] args) {
       BinaryTree tree=new BinaryTree();
       tree.root = new Node(1);
       tree.root.left = new Node(2);
       tree.root.right = new Node(1);

       BinaryTree tree1=new BinaryTree();
       tree1.root = new Node(1);
       tree1.root.left  = new Node(1);
       tree1.root.right = new Node(2);
        System.out.println(isSameTree(tree.root, tree1.root));
//        BinaryTree bTree=new BinaryTree();
//        bTree.populate(new Scanner(System.in));
//        bTree.display();

    }

    // https://leetcode.com/problems/same-tree/description/
    // Check whether two trees are the same
    static boolean isSameTree(Node treeP, Node treeQ){

        // Base case, if the two trees are null
        if (treeP == null && treeQ == null)
            return true;

        // If either of the trees are null or their values aren't the same
        if ((treeP == null || treeQ == null) || treeP.data != treeQ.data)
            return false;

        return isSameTree(treeP.left, treeQ.left) &&
                isSameTree(treeP.right, treeQ.right);
    }

    /*
    A symmetric binary search tree is a type of binary search tree where the left and right subtrees are mirror images of each other.
    In other words, the left and right subtrees have identical shapes and the corresponding nodes have equal values.

    In general, a symmetric binary search tree has the following properties:
    The left and right subtrees are mirror images of each other.
    Corresponding nodes at the same level have equal values.
    The shape of the left and right subtrees are identical.
     */
    public boolean isSymmetricTree(Node node){
        if (node == null)
            return true;
        return isMirrorImage(node.left, node.right);
    }
    private static boolean isMirrorImage(Node node1, Node node2){
        if (node1 == null && node2 == null)
            return true;

        if ((node1 == null || node2 == null) || node1.data != node2.data)
            return false;

        return isMirrorImage(node1.left, node2.right)
                && isMirrorImage(node1.right,node2.left);
    }
    private static void printer() {
        BinaryTree bTree = new BinaryTree();
        bTree.root = new Node(1);
        bTree.root.left = new Node(12);
        bTree.root.right = new Node(9);
        bTree.root.left.left = new Node(5);
        bTree.root.left.right = new Node(6);

        System.out.println("Inorder Traversal");
        bTree.inOrder(bTree.root);
        System.out.println();

        System.out.println("PreOrder Traversal");
        bTree.preOrder(bTree.root);
        System.out.println();

        System.out.println("postOrder Traversal");
        bTree.postOrder(bTree.root);
    }
}
