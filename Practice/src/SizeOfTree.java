public class SizeOfTree {

    private int sizeOfTree(Node root) {
        if (root == null) return 0;
        int left = sizeOfTree(root.left);
        int right = sizeOfTree(root.right);
        return 1+left+right;
    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        SizeOfTree s1 = new SizeOfTree();
        t1.root = new Node(10);
        t1.root.left = new Node(-5);
        t1.root.left.left = new Node(-10);
        t1.root.left.right = new Node(0);
        t1.root.left.right.right = new Node(5);
        t1.root.right = new Node(30);
        t1.root.right.right = new Node(36);

        System.out.println(s1.sizeOfTree(t1.root));
    }
}
