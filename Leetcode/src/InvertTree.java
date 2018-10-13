import java.util.Stack;

public class InvertTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }


    private  TreeNode invertTreeV1(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode node, left;
        while (!st.empty()) {
            node = st.pop();
            left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                st.push(node.left);

            }
            if (node.right != null) {
                st.push(node.right);

            }
        }

        return root;
    }
    public static void main(String[] args) {
        InvertTree t  = new InvertTree();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode root1 = root;

//        TreeNode result =  t.invertTree(root);
//        System.out.println("Done");

        TreeNode result =  t.invertTreeV1(root1);
        System.out.println("Done");

    }
}
