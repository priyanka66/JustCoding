public class InsertToBST {

    private Node insertIntoBST (Node root, int key) {
        Node node = new Node(key);
        if (root == null) return node;
        Node parent = null;
        Node cur = root;
        while (cur!=null) {
            parent = cur;
            if (key < cur.data) cur = cur.left;
            else cur = cur.right;
        }
        if (key<parent.data) parent.left = node;
        else parent.right = node;
        return root;
    }

    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        InsertToBST b1 = new InsertToBST();
        InOrder i1 = new InOrder();
        t1.root = new Node(10);
        t1.root.left = new Node(-5);
        t1.root.left.left = new Node(-8);
        t1.root.left.right = new Node(7);
        t1.root.right = new Node(16);
        t1.root.right.right = new Node(18);
        i1.inOrder(t1.root);
        System.out.println("");
        b1.insertIntoBST(t1.root, 6);
        i1.inOrder(t1.root);

    }
}
