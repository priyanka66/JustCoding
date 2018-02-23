public class SumTree {


    int SumBinaryTree (Node node) {
        if (node == null) return 0;
        int nodeOldVal = node.data;
        node.data = SumBinaryTree(node.left) + SumBinaryTree(node.right);

        return node.data + nodeOldVal;
    }
    public static void main(String[] args) {
        SumTree s1 = new SumTree();
        buildTree b1 = new buildTree();
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(10);
        t1.root.left = new Node(-2);
        t1.root.right = new Node(6);
        t1.root.left.left = new Node(8);
        t1.root.left.right = new Node(-4);
        t1.root.right.left = new Node(7);
        t1.root.right.right = new Node(5);

        System.out.println("Inorder traversal of  tree ");
        b1.printInorder(t1.root);

        s1.SumBinaryTree(t1.root);
        System.out.println("\n Inorder traversal of sum tree ");
        b1.printInorder(t1.root);



    }
}
