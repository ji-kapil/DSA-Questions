// this is not a question only for understanding how tree basic work in the coding

import java.util.*;

public class Height_Of_Tree {

    // Node class represents each node in the binary tree
    static class Node {
        int data;       // Value stored in the node
        Node left, right; // Left and right child nodes

        // Constructor to initialize a node with data
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Method to calculate the height of the binary tree --> O(n) & space is constant
    public static int height(Node root) {
        if (root == null) {
            return 0; // Base case: height of empty tree is 0
        }

        // Recursively calculate height of left and right subtrees
        int lheight = height(root.left);
        int rheight = height(root.right);

        // Return the greater height between left and right, plus 1 for current node
        return Math.max(lheight, rheight) + 1;
    }

    // Method to calculate the number of nodes in the tree --> O(n) & space is constant
    public static int max(Node root) {
        if (root == null) {
            return 0; // Base case: no node present
        }

        // Recursively count nodes in left and right subtrees and add 1 for current node
        int lmax = max(root.left);
        int rmax = max(root.right);

        return lmax + rmax + 1;
    }

    // Method to calculate the sum of all node values in the tree
    public static int sum(Node root) {
        if (root == null) {
            return 0; // Base case: no value to add
        }

        // Recursively sum values in left and right subtrees and add current node's data --> O(n) & space is constant
        int lsum = sum(root.left);
        int rsum = sum(root.right);

        return lsum + rsum + root.data;
    }
    

    public static void main(String[] args) {

        // Manually constructing the binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Print the results
        System.out.println("Height of the tree is : " + height(root));       // Should output 3
        System.out.println("No of nodes in the tree is : " + max(root));     // Should output 7
        System.out.println("Sum of nodes in the tree is : " + sum(root));    // Should output 28
    }
}
