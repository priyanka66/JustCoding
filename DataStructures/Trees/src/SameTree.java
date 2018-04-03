public class SameTree {

    static boolean sameTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) return  true;
        if (root1 == null || root2 == null) return false;
        return root1.data == root2.data
                && sameTree(root1.left, root2.left)
                && sameTree(root1.right,root2.right);

    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(1);
        t1.root.left = new Node(3);
        t1.root.right = new Node(2);
        t1.root.right.left = new Node(5);
        t1.root.right.right = new Node(4);

        BinaryTree t2 = new BinaryTree();
        t2.root = new Node(1);
        t2.root.left = new Node(3);
        t2.root.right = new Node(2);
        t2.root.right.left = new Node(5);
        t2.root.right.right = new Node(4);



        if(sameTree(t1.root, t2.root)) System.out.println("Identical");
        else System.out.println("Not Identical");

    }
}
