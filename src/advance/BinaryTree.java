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
    public void inOrder(Node node){
        if (node == null)
            return;

        inOrder(node.left); // Left node
        System.out.print(node.data + " -> "); // The root node
        inOrder(node.right); // Right
    }

    // Post Order traversal: Left, Right, Root
    public void postOrder(Node node){
        if (node == null)
            return;

        postOrder(node.left); // Left node
        postOrder(node.right); // Right node
        System.out.print(node.data + " -> ");
    }

    // Populate the tree
    public void populate(Scanner scanner) {
        System.out.println("Enter the value of root node: ");
        int value = scanner.nextInt();
        this.root = new Node(value);
        populate(scanner, this.root);
    }

    public void populate(Scanner scanner, Node node) {
        System.out.println("Do you wanna enter left of " + node.data);

        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the left of " + node.data);
            int value = scanner.nextInt();
            node.left = new Node(value); // Insert left node
            populate(scanner, node.left);
        }

        System.out.println("Do you wanna enter right of " + node.data);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter right of " + node.data);
            int value = scanner.nextInt();
            node.right = new Node(value); // insert right node
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null)
            return;

        System.out.println(indent + node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public static void main(String[] args) {
        printer();
//        BinaryTree bTree=new BinaryTree();
//        bTree.populate(new Scanner(System.in));
//        bTree.display();

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
