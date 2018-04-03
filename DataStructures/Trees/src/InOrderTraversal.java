import java.util.Stack;

public class InOrderTraversal {

    Node root;
    InOrderTraversal (int val) {
        root = new Node(val);
    }
    InOrderTraversal() {
        root = null;
    }

    void InOrderIterative(Node root) {
        if (root == null) return;
        Stack<Node> st = new Stack<>();
        while (true) {
            if(root != null) {
                st.push(root);
                root = root.left;
            } else {
                if (st.isEmpty()) break;
                root = st.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }
    }
    public static void main(String[] args) {
        InOrderTraversal t1 = new InOrderTraversal();
        t1.root = new Node(10);
        t1.root.left = new Node(0);
        t1.root.right = new Node(-10);
        t1.root.left.left = new Node(5);
        t1.root.left.right = new Node(6);
//        t1.root.right.left = new Node(0);
        t1.root.right.right = new Node(11);
//        t1.root.right.left.left = new Node(16);
//        t1.root.right.left.right = new Node(18);

        System.out.println("\nIterative Pre Order Traversal");
        t1.InOrderIterative(t1.root);


    }
}

