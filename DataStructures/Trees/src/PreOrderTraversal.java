import java.util.Stack;

public class PreOrderTraversal {

    Node root;
    PreOrderTraversal (int val) {
        root = new Node(val);
    }
    PreOrderTraversal() {
        root = null;
    }

    void preOrderIterative(Node root) {
        if (root == null) return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            System.out.println(root.data);
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }
    }
    public static void main(String[] args) {
        PreOrderTraversal t1 = new PreOrderTraversal();
        t1.root = new Node(10);
        t1.root.left = new Node(11);
        t1.root.right = new Node(-20);
        t1.root.left.left = new Node(15);
        t1.root.left.right = new Node(12);
        t1.root.right.left = new Node(0);
        t1.root.right.right = new Node(9);
        t1.root.right.left.left = new Node(16);
        t1.root.right.left.right = new Node(18);

        System.out.println("\nIterative Pre Order Traversal");
        t1.preOrderIterative(t1.root);


    }
}

