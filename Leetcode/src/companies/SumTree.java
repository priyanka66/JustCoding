package companies;

public class SumTree {

    public static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x) {
            val=x;
        }
    }
    private boolean isSumTree(TreeNode node) {

        if (node == null || (node.left==null && node.right == null)) return true;

        int left = sum(node.left);
        int right = sum(node.right);

        if (node.val == (left+right)) {
            if (isSumTree(node.left) && isSumTree(node.right)) return true;
            else return false;
        }

        return false;
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;

        return sum(node.left) + node.val + sum(node.right);
    }


    public static void main(String[] args) {
        SumTree i = new SumTree();
        TreeNode t1 = new TreeNode(26);
        t1.left = new TreeNode(6);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(10);
        t1.right.right = new TreeNode(3);
        System.out.println(i.isSumTree(t1));

    }


}
