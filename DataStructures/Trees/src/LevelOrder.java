
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder {



    void levelOrder(Node root) {
        if (root == null) return ;
       Queue<Node> q = new LinkedList<>();
       q.add(root);
       while (!q.isEmpty()) {
           root =  q.poll();
           System.out.println(root.data);
           if(root.left!=null) q.add(root.left);
           if (root.right != null) q.add(root.right);
       }
    }

    void  reverselevelOrder(Node root) {
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
        LevelOrder l1 = new LevelOrder();
        t1.root = new Node(1);
        t1.root.left = new Node(2);
        t1.root.right = new Node(3);
        t1.root.left.left = new Node(4);
        t1.root.left.right = new Node(5);
        t1.root.right.left = new Node(6);
        t1.root.right.right = new Node(7);

        System.out.println("\n Level Order Traversal");
        l1.levelOrder(t1.root);

        System.out.println("\n Reverse Level Order Traversal");
        t1.reverselevelOrder();

    }
}


