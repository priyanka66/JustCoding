public class HeightOfBinaryTree {

    private int getHeight(Node root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) +1;
    }

    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        HeightOfBinaryTree s1 = new HeightOfBinaryTree();
        t1.root = new Node(10);
        t1.root.left = new Node(-5);
        t1.root.left.left = new Node(-10);
        t1.root.left.right = new Node(0);
        t1.root.left.right.right = new Node(5);
        t1.root.right = new Node(30);
        t1.root.right.right = new Node(36);

        System.out.println(s1.getHeight(t1.root));
    }
}
