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

    void postOrderIterative(Node root) {
        if (root == null) return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            root = s1.pop();
            s2.push(root);
            if(root.left != null) s1.push(root.left);
            if(root.right!=null) s1.push(root.right);
        }
        while (!s2.isEmpty()) {
            root = s2.pop();
            System.out.println(root.data);
        }
    }

    public static void postOrderIterativeV2(Node root) {
        Node current = root;
        Stack<Node> st = new Stack<>();
        while (current != null || !st.isEmpty()) {
            if(current != null) {
                st.push(current);
                current = current.left;
            }
            else {
                Node temp = st.peek().right;
                if (temp == null) {
                    temp = st.pop();
                    System.out.println(temp.data);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        System.out.println(temp.data);
                    }
                }


                else {
                    current = temp;
                }
            }
        }
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


        System.out.println("\nPost Order Traversal ");
        t1.postOrder();

        System.out.println("\nIterative Post Order Traversal- 2 stacks\"");
        t1.postOrderIterative(t1.root);

        System.out.println("\nPost Order Traversal with one stack");
        t1.postOrderIterativeV2(t1.root);

    }
}


