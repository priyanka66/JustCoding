public class LeftSumTree {

    int LeftSumBinaryTree(Node node) {
        if (node == null) return 0;

        if(node.left == null && node.right == null) return node.data;

        int leftSum = LeftSumBinaryTree(node.left);
        int rightSum = LeftSumBinaryTree(node.right);

        node.data = node.data + leftSum;

        return node.data + rightSum;

    }
    public static void main(String[] args) {
        LeftSumTree s1 = new LeftSumTree();
        buildTree b1 = new buildTree();
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(1);
        t1.root.left = new Node(2);
        t1.root.right = new Node(3);
        t1.root.left.left = new Node(4);
        t1.root.left.right = new Node(5);
        t1.root.right.right = new Node(6);

        System.out.println("Inorder traversal of  tree ");
        b1.printInorder(t1.root);

        s1.LeftSumBinaryTree(t1.root);
        System.out.println("\n Inorder traversal of sum tree ");
        b1.printInorder(t1.root);


    }
}
