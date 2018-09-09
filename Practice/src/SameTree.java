public class SameTree {

    private boolean isSameTree(Node t1, Node t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.data == t2.data && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right));
    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        BinaryTree t2 = new BinaryTree();
        SameTree s1 = new SameTree();
        t1.root = new Node(10);
        t1.root.left = new Node(15);
//        t1.root.left.left = new Node(-8);
//        t1.root.left.right = new Node(7);
        t1.root.right = new Node(18);
        t1.root.right.left = new Node(2);

        t2.root = new Node(10);
        t2.root.left = new Node(15);
//        t1.root.left.left = new Node(-8);
//        t1.root.left.right = new Node(7);
        t2.root.right = new Node(18);
        t2.root.right.left = new Node(21);
        System.out.println(s1.isSameTree(t1.root, t2.root));
    }
}
