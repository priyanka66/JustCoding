public class InsertToBinaryTree {

    Node insertInto(Node root, int key) {
        Node node = new Node(key);
        if (root == null) return  node;
        Node parent = null, current = root;
        while (current!=null) {
            parent = current;
            if (key < current.data) current = current.left;
            else current = current.right;
        }
        if (key <= parent.data) parent.left = node;
        else parent.right = node;
        return root;

    }
    public static void main(String[] args) {
        InsertToBinaryTree s1 = new InsertToBinaryTree();
        BinaryTree t1 = new BinaryTree();
        buildTree b1 = new buildTree();
        int key = 6;
        t1.root = new Node(10);
        t1.root.left = new Node(-5);
        t1.root.right = new Node(16);
        t1.root.left.left = new Node(-8);
        t1.root.left.right = new Node(7);
//        t1.root.right.left = new Node();
        t1.root.right.right = new Node(18);
        Node r1 = s1.insertInto(t1.root, key);
        System.out.println("Inorder traversal of  tree ");
        b1.printInorder(r1);

    }

}
