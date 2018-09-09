public class SymmetricTree {

    private boolean checkIsSymmetric(Node p, Node q) {
        if (p == null || q == null) return p == q;
        return (p.data == q.data) && checkIsSymmetric(p.left, q.right) && checkIsSymmetric(p.right, q.left);
    }
    private boolean isSymmetric(Node root) {
        if (root == null) return true;

        return checkIsSymmetric(root.left, root.right);
    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        SymmetricTree b1 = new SymmetricTree();
        t1.root = new Node(1);
        t1.root.left = new Node(1);
        t1.root.left.right = new Node(4);
        t1.root.left.left = new Node(3);

        t1.root.right = new Node(1);
        t1.root.right.left = new Node(4);
        t1.root.right.right = new Node(31);

        System.out.println(b1.isSymmetric(t1.root));

    }
}
