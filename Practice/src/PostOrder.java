public class PostOrder {

    private void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
    public static void main(String[] args){
        BinaryTree t1 = new BinaryTree();
        PostOrder p1 = new PostOrder();
        t1.root = new Node(10);
        t1.root.left = new Node(2);
        t1.root.left.left = new Node(6);
        t1.root.right = new Node(5);
        t1.root.right.left = new Node(8);
        t1.root.right.right = new Node(3);
        p1.postOrder(t1.root);

    }
}
