
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
public class BinaryTree {

    Node root;
    BinaryTree (int val) {
        root = new Node(val);
    }
    BinaryTree() {
        root = null;
    }

    static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    static void inOrderRec(Node node) {
        if (node == null) return;
        inOrderRec(node.left);
        System.out.print(node.data + " ");
        inOrderRec(node.right);

    }

    void preOrder() {
        preOrder(root);
    }

    void postOrder() {
        postOrder(root);
    }

    void inOrderRec() {
        inOrderRec(root);
    }

    void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
    }

    void inOrderStack() {
        Stack<Node> st = new Stack<>();
        if (root == null) return;
        Node node = root;
        while (node != null) {
            st.push(node);
            node = node.left;
        }

        while (st.size()>0) {
            node = st.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                node = node.right;
                while (node!=null) {
                    st.push(node);
                    node = node.left;
                }
            }
        }
    }

    void  inOrder() {
        Node current , prev;
        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                prev = current.left;
                while(prev.right != null && current!=prev.right) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
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

    void  reverselevelOrder() {
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        queue.add(root);
        Node node = null;
        while(!queue.isEmpty()) {
            node = queue.poll();
            st.push(node.data);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

         }

         while ((!st.empty())) {
            int val = st.peek();
            System.out.print(val + " ");
            st.pop();
         }
    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(1);
        t1.root.left = new Node(2);
        t1.root.right = new Node(3);
        t1.root.left.left = new Node(4);
        t1.root.left.right = new Node(5);
        t1.root.right.left = new Node(6);
        t1.root.right.right = new Node(7);

//        System.out.println("Pre order traversal ");
//        t1.preOrder();
//
//        System.out.println("\nPost Order Traversal");
//        t1.postOrder();
//
//        System.out.println("\nIn Order Traversal");
//        t1.inOrderRec();
//
        System.out.println("\n Level Order Traversal");
        t1.levelOrder();

        System.out.println("\n Reverse Level Order Traversal");
        t1.reverselevelOrder();

//        System.out.println("\nIn Order Traversal with stack");
//        t1.inOrderStack();
//
//        System.out.println("\nIn Order Traversal without stack");
//        t1.inOrder();
//
//
//        System.out.println("\nIterative Post Order Traversal");
//        ArrayList<Integer> list = new ArrayList<Integer>();
//                list = t1.postOrderIterative();
//        System.out.print(list);







    }
}


