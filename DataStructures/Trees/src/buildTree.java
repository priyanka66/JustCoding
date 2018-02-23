import java.util.Arrays;

public class buildTree {

    int preInIndex = 0;
    int prePostIndex =0;

    Node buildUsingPreIn (int in[], int pre[], int start, int end) {
        if (start > end) return null;

        Node tree = new Node(pre[preInIndex++]);
        if (start == end) return tree;
        int inIndex =  searchInd(in, start, end, tree.data);

        tree.left = buildUsingPreIn(in, pre, start, inIndex-1);
        tree.right = buildUsingPreIn(in, pre, inIndex+1, end);

        return tree;
    }

    int searchInd(int in[], int start, int end, int val) {
        int i;
        for(i = start; i< end; i++) {
            if (in[i] == val) return i;

        }
        return i;
    }

    Node buildUsingPrePost(int pre[], int post[], int start, int end, int size) {
        if (prePostIndex >= size || start>end)
            return null;
        Node tree = new Node(pre[prePostIndex++]);

        if (start == end || prePostIndex >=size) {
            return tree;
        }

        int i;
        for (i=start; i<=end; i++) {
            if (post[i] == pre[prePostIndex]) break;
        }

        if (i<=end) {
            tree.left = buildUsingPrePost(pre, post, start, i, size);
            tree.right = buildUsingPrePost(pre, post, i+1, end, size);
        }

        return tree;
    }
    void printInorder(Node root) {
        if (root==null) return ;
        printInorder(root.left);
        System.out.print(root.data + "  ");
        printInorder(root.right);
    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        buildTree b1 = new buildTree();
        int[] in = {4,2,5,1,3,6};
        int[] pre = {1,2,4,5,3,6};
        int[] post = {4,5,2,6,3,1};


        int len = in.length;

        System.out.println("Inorder traversal of  tree constructed from post and pre order traversals ");
        Node tree1 = b1.buildUsingPreIn(in, pre, 0, len - 1);
        b1.printInorder(tree1);


        System.out.println("Inorder traversal of  tree constructed from level and pre order traversals : ");
        Node tree2 = b1.buildUsingPrePost(pre, post, 0, len - 1, len);
        b1.printInorder(tree2);
    }
}
