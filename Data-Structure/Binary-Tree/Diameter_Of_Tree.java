// Number of nodes in the longest path between 2 leaf



import java.util.*;

public class Diameter_Of_Tree{

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


    // case - 1 if Diamter pass by the root (time --> O(n*n) and space is constant )
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

    public static int diameter(Node root){
        if (root == null) {
            return 0; // Base case: height of empty tree is 0
        }

        // call for diameters
        int ldiam = diameter(root.left);
        int lh = height(root.left);
        int rdiam = diameter(root.right);
        int rh = height(root.right);

        int selfdiam = lh + rh + 1 ;

        return Math.max(selfdiam, (Math.max(ldiam , rdiam)));
    }



  // case 2 - to find the diameter with time O(n)
    static class Info{
        int diameter , height ;
        public Info(int diameter, int height){
            this.diameter =diameter;
            this.height = height ;
        }
    }
        

    public static Info diameters(Node root){

        if(root == null){
            return new Info(0,0);
        }

        Info leftInfo = diameters(root.left);
        Info rightInfo = diameters(root.right);

        int diameter = Math.max( Math.max (leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1 ;
        return new Info(diameter ,height);


    }

    
    public static void main(String[] args){
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

        System.out.println("max diameter with time O(n*n) of the tree is : " + diameter(root));

        System.out.println("max diameter with time O(n) of the tree is : " + diameters(root).diameter);

    }
}

