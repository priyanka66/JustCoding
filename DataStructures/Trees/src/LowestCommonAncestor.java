public class LowestCommonAncestor {

    public static Node LCA(Node root, int l1, int l2) {
        if (root == null) return null;
        if (root.data == l1 || root.data == l2) return root;
        Node left = LCA(root.left, l1, l2);
        Node right = LCA(root.right, l1, l2);
        if (left != null && right != null) return root;
        if (left == null && right == null) return null;

        return left != null ? left:right;

    }

    public  static Node LCABST(Node root, int n1, int n2) {
        if(root.data > Math.max(n1, n2)) {
            return LCABST(root.left, n1, n2);
        } else if (root.data < Math.min(n1,n2)) {
            return LCABST(root.right, n1, n2);
        } else {
            return root;
        }
    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(3);
        t1.root.left = new Node(6);
        t1.root.right = new Node(8);
        t1.root.left.left = new Node(2);
        t1.root.left.right = new Node(11);
//        t1.root.right.left = new Node(17);
        t1.root.right.right = new Node(13);
        int n1 =  2;
        int n2 = 11;
        Node result = (LCA(t1.root, n1, n2));
        System.out.println(result.data);

        t1.root = new Node(10);
        t1.root.left = new Node(-10);
        t1.root.right = new Node(30);
//        t1.root.left.left = new Node(2);
        t1.root.left.right = new Node(8);
        t1.root.left.right.left = new Node(6);
        t1.root.left.right.right = new Node(9);

        t1.root.right.left = new Node(25);
        t1.root.right.right = new Node(60);
        n1 =  6;
        n2 = 9;
        result = (LCABST(t1.root, n1, n2));
        System.out.println(result.data);

    }
}
