package ng.shoppi;

public class BST {

    private static Node insertWithIteration(Node root, int data) {

        if (root == null) {
            return new Node(data);
        }
        Node temp = root;
        while (temp != null) {
            if (data <= temp.data) {
                if (temp.left == null) {
                    temp.left = new Node(data);
                    temp = null;
                } else
                    temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = new Node(data);
                    temp = null;
                } else
                    temp = temp.right;
            }
        }
        return root;
    }

    private static Node insert(Node root, int data) {

        if (root == null)
            root = new Node(data);
        else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    private static boolean search(Node root, int data) {
        if (root == null) return false;
        if (root.data == data) return true;
        if (data <= root.data) return search(root.left, data);
        else return search(root.right, data);
    }

//    public static boolean searchWithIteration(Node root, int data) {
//        if (root == null) return false;
//        if (root.data == data) return true;
//        Node temp = root;
//        while (temp != null) {
//            if (data <= temp.data) {
//                temp = temp.left;
//                if (data == temp.data) return true;
//            } else {
//                temp = temp.right;
//                if (temp.data == data) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    private static int findMin(Node root){
        if(root == null)
            return  -1;
        while(root.left != null)
            root = root.left;
        return root.data;
    }

    private static int findMax(Node root){
        if(root == null)
            return  -1;
        while(root.right != null)
            root = root.right;
        return root.data;
    }
    private static int findMinRecursion(Node root){
        if(root == null)
            return  -1;
        if(root.left == null)
            return root.data;
        return findMaxRecursion(root.left);
    }
    private static int findMaxRecursion(Node root){
        if(root == null)
            return  -1;
        if(root.right == null)
            return root.data;
        return findMaxRecursion(root.right);
    }

    private static int findHeightOfTree(Node root){
        if(root == null)
            return -1;
        return Math.max(findHeightOfTree(root.left), findHeightOfTree(root.right)) + 1;

    }
    private static int checkBalanced(Node root){
        if(root == null)
            return -1;
        if(Math.abs(checkBalanced(root.left) - checkBalanced(root.right)) <=1)
            return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insertWithIteration(root, 20);
        root = insertWithIteration(root, 15);
        root = insertWithIteration(root, 30);
        root = insertWithIteration(root, 25);
        root = insertWithIteration(root, 5);
        root = insertWithIteration(root, 2);
        root = insertWithIteration(root, 1);

        System.out.println("Searching for 30 " + search(root, 26));
        System.out.println("Finding max with recursion " + findMaxRecursion(root));
        System.out.println("Finding max with iteration " + findMax(root));
        System.out.println("Finding min with recursion " + findMinRecursion(root));
        System.out.println("Finding min with iteration " + findMin(root));
        System.out.println("Height of three is " + findHeightOfTree(root));
        System.out.println("Balance of three is " + checkBalanced(root));
    }

    public static class Node {
        Node right;
        Node left;
        int data;

        public Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }
}
