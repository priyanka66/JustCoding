public class isBST {

    private boolean isBST(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data < min || root.data > max) return false;

        return isBST(root.left, min, root.data) &&
                isBST(root.right, root.data, max);

    }

    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        isBST s1 = new isBST();
        t1.root = new Node(10);
        t1.root.left = new Node(8);
        t1.root.right = new Node(2);
        t1.root.left.left = new Node(3);
        t1.root.left.right = new Node(5);
        t1.root.right.right = new Node(4);
        System.out.println(s1.isBST(t1.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        t1.root = new Node(10);
        t1.root.left = new Node(10);
        t1.root.right = new Node(19);
        t1.root.left.left = new Node(-5);
        t1.root.right.left = new Node(17);
        t1.root.right.right = new Node(21);
        System.out.println(s1.isBST(t1.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }
}
