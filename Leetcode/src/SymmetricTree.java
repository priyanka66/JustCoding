import java.util.Stack;

public class SymmetricTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode getMirror(TreeNode p) {
       if (p == null) return p;
       TreeNode left = getMirror(p.left);
       TreeNode right = getMirror(p.right);

       p.right = left;
       p.left = right;

       return p;

    }
    static boolean isSymmetric(TreeNode root) {
        SymmetricTree s1 = new SymmetricTree();
        if (root == null) return true;

        return s1.checkIfSymmetric(root.left, root.right);
    }

    public boolean checkIfSymmetric(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        return checkIfSymmetric(p.left, q.right) && checkIfSymmetric(p.right, q.left);
    }

    static boolean isSymmetricIter(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode left, right;
        if (root == null) return true;
        if (root.left != null) {
            if (root.right == null) return false;
            st.push(root.left);
            st.push(root.right);
        }

        while (!st.empty()) {
            if (st.size() % 2 != 0) return false;
            right = st.pop();
            left = st.pop();
            if (left.val != right.val) return false;
            if (left.left !=null) {
                if (right.right == null) return false;
                st.push(left.left);
                st.push(right.right);
            } else if (right.right != null) return false;

            if (left.right != null) {
                if (right.left == null) return false;
                st.push(left.right);
                st.push(right.left);
            } else if (right.left != null) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        SymmetricTree s1 = new SymmetricTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);
//        p.left.left = new TreeNode();
        p.left.right = new TreeNode(3);
//        p.right.left = new TreeNode(2);
        p.right.right = new TreeNode(2);

        if(isSymmetric(p)) System.out.println("Symmetric");
        else System.out.println("Not Symmetric");

        if(isSymmetricIter(p)) System.out.println("Symmetric");
        else System.out.println("Not Symmetric");




    }
}
