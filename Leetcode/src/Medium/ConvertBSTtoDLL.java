package Medium;

import java.util.Stack;

public class ConvertBSTtoDLL {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    public Node treeToDoublyList(Node root) {
        if (root == null) return root ;
        Node head = new Node(0, null, null);
        Node prev = head;
        Stack<Node> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            Node node = st.pop();
            root = node.right;
            node.left = prev;
            prev.right = node;
            prev = node;
        }

        prev.right = head.right;
        head.right.left = prev;
        return head.right;
    }

    public static void main(String[] args) {
        ConvertBSTtoDLL c = new ConvertBSTtoDLL();
        Node root = new Node(4, null, null);
        root.left = new Node(2, null, null);
        root.right = new Node(5, null, null);
        root.left.left = new Node(1, null, null);
        root.left.right = new Node(3, null, null);
        Node result = c.treeToDoublyList(root);
        System.out.println("Done");
    }
}
