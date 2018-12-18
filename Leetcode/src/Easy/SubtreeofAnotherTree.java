package Easy;

public class SubtreeofAnotherTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s,t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t== null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left,t.left) && isSame(s.right, t.right);
    }
    public static void main(String[] args) {
        SubtreeofAnotherTree s = new SubtreeofAnotherTree();
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(4);
        p.right = new TreeNode(5);
        p.left.left = new TreeNode(1);
        p.left.right = new TreeNode(2);

        TreeNode q = new TreeNode(4);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println(s.isSubtree(p,q));
    }
}
