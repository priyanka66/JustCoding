import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    public void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);
    }

    public List<Integer> getNodes(Node root, List<Integer> res) {
        if (root == null) return res;
        if (root.left != null) getNodes(root.left, res);
        res.add(root.data);
        if (root.right != null) getNodes(root.right, res);

        return res;
    }

    public List<Integer> inOrderNodes(Node root) {
        List<Integer> res = new ArrayList<>();

        res = getNodes(root, res);
        return res;
    }

    public List<Integer> inOrderNodesV2(Node root) {
       List<Integer> res = new ArrayList<>();
       if (root == null) return res;

       Stack<Node> st = new Stack<>();
       while (!st.isEmpty() || root != null) {
           while (root != null) {
               st.push(root);
               root = root.left;
           }

           root = st.pop();
           res.add(root.data);
           root = root.right;

       }

       return res;
    }

    public static void main(String[] args){
        BinaryTree t1 = new BinaryTree();
        InOrder p1 = new InOrder();
        t1.root = new Node(10);
        t1.root.left = new Node(2);
        t1.root.left.left = new Node(6);
        t1.root.right = new Node(5);
        t1.root.right.left = new Node(8);
        t1.root.right.right = new Node(3);

        p1.inOrder(t1.root);
        System.out.println();

        System.out.println(p1.inOrderNodes(t1.root));
        System.out.println();
        System.out.println(p1.inOrderNodesV2(t1.root));

    }
}
