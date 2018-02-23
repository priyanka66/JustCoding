public class MirrorTree {

    Node MirrorBinaryTree(Node node) {
        if (node == null) return node;

        Node left = MirrorBinaryTree(node.left);
        Node right = MirrorBinaryTree(node.right);

        node.left = right;
        node.right = left;

        return node;
    }
    public static void main(String[] args) {
        MirrorTree s1 = new MirrorTree();
        buildTree b1 = new buildTree();
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(1);
        t1.root.left = new Node(3);
        t1.root.right = new Node(2);
        t1.root.right.left = new Node(5);
        t1.root.right.right = new Node(4);

        System.out.println("Inorder traversal of  tree ");
        b1.printInorder(t1.root);

        Node tree = s1.MirrorBinaryTree(t1.root);
        System.out.println("\n Inorder traversal of Mirror tree ");
        b1.printInorder(tree);


    }
}
