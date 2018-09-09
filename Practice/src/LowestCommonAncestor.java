public class LowestCommonAncestor {

    private int lca (Node root, int a, int b) {
        if (a>root.data && b>root.data) return lca(root.right,a, b);
        if (a<root.data && b<root.data) return lca(root.left, a, b);
        else return root.data;
    }

    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        LowestCommonAncestor b1 = new LowestCommonAncestor();
        t1.root = new Node(10);
        t1.root.left = new Node(-10);
        t1.root.left.right = new Node(8);
        t1.root.left.right.left = new Node(6);
        t1.root.left.right.right = new Node(9);

        t1.root.right = new Node(30);
        t1.root.right.left = new Node(25);
        t1.root.right.right = new Node(60);
        t1.root.right.right.right = new Node(78);
        t1.root.right.left.right = new Node(28);

        System.out.println(b1.lca(t1.root, 10,70));

    }
}
