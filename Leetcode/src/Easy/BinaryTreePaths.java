package Easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(SymmetricTree.TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        binaryTreePaths(root, "", result);
        return result;
    }

    public void binaryTreePaths(SymmetricTree.TreeNode root, String path, List<String> result) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            result.add(path+root.val);
            return;
        }
        binaryTreePaths(root.left, path + root.val + "->", result);
        binaryTreePaths(root.right, path + root.val + "->", result);

    }

    public static void main(String[] args) {
        SymmetricTree.TreeNode root  = new SymmetricTree.TreeNode(1);
        root.left = new SymmetricTree.TreeNode(2);
        root.right = new SymmetricTree.TreeNode(3);
        root.left.right = new SymmetricTree.TreeNode(4);

        BinaryTreePaths p = new BinaryTreePaths();
        System.out.println(p.binaryTreePaths(root));
    }
}
