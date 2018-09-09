public class PreOrder {

    private void preOrder(Node root) {
        if (root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);

    }
    public static void main(String[] args){
        BinaryTree t1 = new BinaryTree();
        PreOrder p1 = new PreOrder();
        t1.root = new Node(10);
        t1.root.left = new Node(2);
        t1.root.left.left = new Node(6);
        t1.root.right = new Node(5);
        t1.root.right.left = new Node(8);
        t1.root.right.right = new Node(3);
        p1.preOrder(t1.root);

    }
}
