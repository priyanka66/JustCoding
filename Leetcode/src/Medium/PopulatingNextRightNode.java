package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightNode {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> q2 = new LinkedList<TreeLinkNode>();
        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            while (!q1.isEmpty()) {
                TreeLinkNode node = q1.poll();
                if (node.left != null) q2.add(node.left);
                if(node.right != null) q2.add(node.right);
                if (q1.isEmpty()) {
                    node.next = null;
                } else{
                    node.next = q1.peek();
                }
            }

            while (!q2.isEmpty()) {
                TreeLinkNode node = q2.poll();
                if (node.left != null) q1.add(node.left);
                if(node.right != null) q1.add(node.right);
                if (q2.isEmpty()) {
                    node.next = null;
                } else{
                    node.next = q2.peek();
                }
            }
        }

        System.out.println(root);

    }
    public static void main(String[] args){
        PopulatingNextRightNode p = new PopulatingNextRightNode();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        p.connect(root);

    }
}
