public class MaxDepth {

    static int getMaxDepth(Node node) {
        if(node == null) return 0 ;
        int leftDepth = getMaxDepth(node.left);
        int rightDepth = getMaxDepth(node.right);
        return leftDepth > rightDepth ? leftDepth+1 : rightDepth+1;
    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(1);
        t1.root.left = new Node(3);
        t1.root.right = new Node(2);
        t1.root.right.left = new Node(5);
        t1.root.right.right = new Node(4);

        int depth = getMaxDepth(t1.root);
        System.out.println("Depth " + depth);
    }
}
