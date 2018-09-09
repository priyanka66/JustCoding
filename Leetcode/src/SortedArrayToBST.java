
public class SortedArrayToBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) return  new TreeNode(nums[0]);
        int start = 0;
        int end = nums.length-1;
        return createBST(start, nums, end);
    }

    public static TreeNode createBST(int start, int[] nums, int end) {
        if (start > end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(mid);
        root.left = createBST(start, nums, mid-1);
        root.right = createBST(mid+1, nums, end);
        return root;
    }
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode p = sortedArrayToBST(nums);
        System.out.println(p);
    }
}
