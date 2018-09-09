import java.util.*;

public class LevelOrderTraversal {

    private void levelOrderTraversal(Node root) {
        Queue<Node> que = new LinkedList<>();
        if (root == null) return;
        que.add(root);
        while (!que.isEmpty()) {
            root = que.poll();
            System.out.println(root.data);
            if (root.left != null) que.add(root.left);
            if (root.right != null) que.add(root.right);
        }
    }

    private void reverseLevelOrder(Node root) {
        Queue<Node> que = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        que.add(root);
        while (!que.isEmpty()) {
            root = que.poll();
            st.push(root.data);
            if (root.left != null) que.add(root.left);
            if (root.right != null) que.add(root.right);
        }

        while(!st.isEmpty()) {
            System.out.println(st.pop());
        }

    }

    private void zigZagTraversal(Node root) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.add(root);
        Node cur = null;
        while (!st1.isEmpty() || !st2.isEmpty()) {
            while(!st1.isEmpty()) {
                root = st1.pop();
                System.out.print(" " + root.data);
                if (root.left != null) st2.push(root.left);
                if (root.right != null) st2.push(root.right);
            }
            while(!st2.isEmpty()) {
                cur = st2.pop();
                System.out.print(" " +cur.data);
                if (cur.right!= null) st1.push(cur.right);
                if(cur.left != null) st1.push(cur.left);
            }
        }
    }

    private List<List<Integer>> zigZagTraversalNodes(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.add(root);
        while (!st1.isEmpty() || !st2.isEmpty()) {
            List<Integer> res1 = new ArrayList<>();
            while (!st1.isEmpty()) {
                root = st1.pop();
                res1.add(root.data);
                if (root.left != null) st2.push(root.left);
                if (root.right != null) st2.push(root.right);
            }

            if (!res1.isEmpty())
                result.add(res1);
            List<Integer> res2 = new ArrayList<>();

            while (!st2.isEmpty()) {
                root = st2.pop();
                res2.add(root.data);
                if (root.right != null) st1.push(root.right);
                if (root.left != null) st1.push(root.left);
            }

            if (!res2.isEmpty())
                result.add(res2);
        }

        return result;
    }
    private List<List<Integer>> levelOrderTraversalNodes(Node root) {
        List<List<Integer>> nodes = new ArrayList<List<Integer>>();
        if (root == null) return nodes;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty()) {
            List<Integer> res1 = new LinkedList<>();
            while (!q1.isEmpty()) {
                root = q1.poll();
                res1.add(root.data);
                if (root.left != null) q2.add(root.left);
                if (root.right != null) q2.add(root.right);
            }
            if (!res1.isEmpty())
                nodes.add(res1);


            List<Integer> res2 = new LinkedList<>();
            while (!q2.isEmpty()) {
                root = q2.poll();
                res2.add(root.data);
                if (root.left != null) q1.add(root.left);
                if (root.right != null) q1.add(root.right);
            }
            if (!res2.isEmpty())
                nodes.add(res2);
        }
        return nodes;
    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        LevelOrderTraversal b1 = new LevelOrderTraversal();
        t1.root = new Node(1);
        t1.root.left = new Node(2);
        t1.root.left.left = new Node(4);
        t1.root.left.right = new Node(5);
        t1.root.right = new Node(3);
        t1.root.right.right = new Node(6);

        BinaryTree t2 = new BinaryTree();
        t2.root = new Node(3);
        t2.root.left = new Node(9);
        t2.root.right = new Node(20);
        t2.root.right.left = new Node(15);
        t2.root.right.right = new Node(7);

//        b1.levelOrderTraversal(t1.root);
//        b1.reverseLevelOrder(t1.root);
        b1.zigZagTraversal(t1.root);
        System.out.println();
        System.out.println(b1.zigZagTraversalNodes(t1.root));

//        List<List<Integer>> nodes = b1.levelOrderTraversalNodes(t2.root);
//        System.out.println(nodes);


    }
}
