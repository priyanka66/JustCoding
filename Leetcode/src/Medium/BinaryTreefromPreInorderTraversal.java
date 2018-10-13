package Medium;

import java.util.Arrays;
import java.util.Stack;

public class BinaryTreefromPreInorderTraversal {
    public class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    private int getIndex(int[] inorder, int root){
        int i = 0, j= inorder.length-1;
        while (i<=j) {
            if (inorder[i] == root) return i;
            else if (inorder[j] == root) return j;
            i++;
            j--;
        }
        return -1;
    }
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length ==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = getIndex(inorder, root.val);
        if (index != 0) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        }
        if (index != inorder.length) {
            root.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length),Arrays.copyOfRange(inorder, index+1, inorder.length));
        }
        return root;
    }

    private TreeNode buildTreeV2(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length ==0) return null;
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        st.push(root);
        int index = 0;
        for (int i=1; i< preorder.length; i++) {
            TreeNode cur = st.peek();
            if (cur.val != inorder[index]) {
                cur.left = new TreeNode(preorder[i]);
                st.push(cur.left);
            } else {
                while (!st.isEmpty() && (st.peek().val == inorder[index])) {
                    cur = st.pop();
                    index++;
                }
                cur.right = new TreeNode(preorder[i]);
                st.push(cur.right);
            }
        }

        return root;
    }
    public static void main(String[] args) {
        BinaryTreefromPreInorderTraversal t = new BinaryTreefromPreInorderTraversal();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = t.buildTree(preorder, inorder);
        System.out.println("done");

        root = t.buildTreeV2(preorder, inorder);
        System.out.println("done");


    }
}
