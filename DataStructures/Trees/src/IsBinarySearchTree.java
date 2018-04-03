public class IsBinarySearchTree {

    public static boolean isBST(Node root, long min, long max) {
        if (root == null) return true;
        if (root.data <= min || root.data >=max) return false;

        return isBST(root.left, min, root.data)
                && isBST(root.right, root.data, max);
    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(0);
        t1.root.left = new Node(Integer.MIN_VALUE);
        t1.root.right = new Node(Integer.MAX_VALUE);
//        t1.root.left.left = new Node(-5);
////        t1.root.left.right = new Node(5);
//        t1.root.right.left = new Node(17);
//        t1.root.right.right = new Node(21);

        long min =  Integer.MIN_VALUE+1;
        long max = Integer.MAX_VALUE-1;


        if(isBST(t1.root, min, max)) System.out.println("IS BST");
        else System.out.println("NOT BST");

    }

}
