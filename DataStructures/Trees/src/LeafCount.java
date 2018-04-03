public class LeafCount {

    public int getLeafCount(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);

    }
    public static void main(String[] args) {
        LeafCount l1 = new LeafCount();
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(10);
        t1.root.left = new Node(8);
        t1.root.right = new Node(2);
        t1.root.left.left = new Node(3);
        t1.root.left.right = new Node(5);
        t1.root.right.right = new Node(2);


        System.out.println("Leaf count " + l1.getLeafCount(t1.root));


    }
}
