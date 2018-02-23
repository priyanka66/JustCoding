import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//import

//class Node {
//    int data;
//    Node left, right;
//    Node(int val) {
//        data = val;
//        left = right = null;
//    }
//}
public class PostOrderTraversal {

    Node root;
    PostOrderTraversal (int val) {
        root = new Node(val);
    }
    PostOrderTraversal() {
        root = null;
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    void postOrder() {
        postOrder(root);
    }

    ArrayList<Integer> postOrderIterative() {
        Stack<Node> st =  new Stack<>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Node current, prev;
        current = root;
        if (root == null) return result;
        st.push(root);
        prev = null;
        while (!st.isEmpty()) {
            current = st.peek();
            if(prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    st.push(current.left);
                } else if (current.right != null) {
                    st.push(current.right);
                } else {
                    st.pop();
                    result.add(current.data);
                }
            } else if (current.left == prev) {
                if (current.right != null) {
                    st.push(current.right);
                } else {
                    st.pop();
                    result.add(current.data);
                }
            } else if (current.right == prev) {
                st.pop();
                result.add(current.data);
            }

            prev = current;

        }

        return result;
    }
    public static void main(String[] args) {
        PostOrderTraversal t1 = new PostOrderTraversal();
        t1.root = new Node(1);
        t1.root.left = new Node(2);
        t1.root.right = new Node(3);
        t1.root.left.left = new Node(4);
        t1.root.left.right = new Node(5);
        t1.root.right.left = new Node(6);
        t1.root.right.right = new Node(7);


        System.out.println("\nPost Order Traversal");
        t1.postOrder();

        System.out.println("\nIterative Post Order Traversal");
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = t1.postOrderIterative();
        System.out.print(list);


    }
}


