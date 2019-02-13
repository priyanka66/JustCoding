package Medium;

public class BSTIterator {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val  = x;
            left = null;
            right = null;
        }
    }


    private TreeNode curr ;
    BSTIterator(TreeNode root) {
        curr = root;
    }

    public boolean hasNext() {
        return curr!=null;
    }

    public int next() {
        while (curr.left != null) {
            TreeNode temp = curr.left;
            while (temp.right != null && temp.right != curr) temp = temp.right;
            if (temp.right == null) {
                temp.right = curr;
                curr = curr.left;
            } else {
                temp.right = null;
                break;
            }
        }

        int val = curr.val;
        curr = curr.right;
        return val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left =  new TreeNode(3);
        root.right =   new TreeNode(15);
        root.right.left =   new TreeNode(9);
        root.right.right =   new TreeNode(20);
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
//        System.out.println(iterator.next());



    }
}