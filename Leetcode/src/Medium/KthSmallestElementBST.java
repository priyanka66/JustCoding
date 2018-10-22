package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }


    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack();
        while (root != null || !st.empty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            k--;
            if (k ==0) return root.val;
            root = root.right;
        }

        return -1;
    }

    public int kthSmallestV2(TreeNode root, int k) {
        List<Integer> track = new ArrayList<>();
        track.add(0);
        track = getKthSmallest(root, track,k);
        return track.get(1);
    }

    List<Integer> getKthSmallest(TreeNode root, List<Integer> track, int k) {
        if (root ==null) return track;

        track = getKthSmallest(root.left, track, k);
        int count = track.get(0);
        count++;
        if (count == k) {
            track.add(root.val);
            return track;
        }
        track.set(0, count);

        return getKthSmallest(root.right, track, k);
    }


    public static void main(String[] args) {
        KthSmallestElementBST b = new KthSmallestElementBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);

        System.out.println(b.kthSmallest(root, 4));
        System.out.println(b.kthSmallestV2(root, 4));
    }
}
