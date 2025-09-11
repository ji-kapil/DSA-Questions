// this is not a question only for understanding how build tree in the coding


import java.util.*;

public class Build_Tree {

    // Node class to represent each node of the binary tree
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        // Function to create a binary tree from an array using preorder traversal
        // -1 in the array represents a null node
        public static Node createTree(int[] nodes) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = createTree(nodes);   // Recursive call to build left subtree
            newNode.right = createTree(nodes);  // Recursive call to build right subtree

            return newNode;
        }

        // Function to print pre-order traversal of the tree (Root -> Left -> Right) --> O(n) & space is constant
        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        // Function to print in-order traversal of the tree (Left -> Root -> Right) --> O(n) & space is constant
        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        // Function to print post-order traversal of the tree (Left -> Right -> Root) --> O(n) & space is constant
        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        // Function to print level-order traversal of the tree (Breadth-first traversal) --> O(n) & space is constant
        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);  // Marker to indicate the end of a level

            while (!q.isEmpty()) {
                Node currNode = q.remove();

                if (currNode == null) {
                    // End of the current level
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);  // Add marker for next level
                    }
                } else {
                    // Print current node's data
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Array representing the binary tree in preorder
        // -1 indicates a null node

        // Tree represented in pre-order with -1 as null
        // Example tree: 
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6



        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.createTree(nodes);

        // Pre-order traversal
        System.out.print("Pre order tree is : ");
        tree.preOrder(root);

        // In-order traversal
        System.out.println();
        System.out.print("In order tree is : ");
        tree.inOrder(root);

        // Post-order traversal
        System.out.println();
        System.out.print("Post order of tree is : ");
        tree.postOrder(root);

        // Level-order traversal
        System.out.println();
        System.out.println("Level order of tree is : ");
        tree.levelOrder(root);
    }
}
