import java.util.ArrayList;
import java.util.List;

public class RootToLeafSum {
    private boolean rootToLeafSum(Node root, int sum, List<Integer> result) {
//        if (root == null) return false;
//        if (root.left == null && root.right == null) {
//            if (root.data == sum) {
//                result.add(root.data);
//                return true;
//            } else return false;
//        }
//
//        if (rootToLeafSum(root.left, sum-root.data, result)) {
//            result.add(root.data);
//            return true;
//        }
//        if (rootToLeafSum(root.right, sum-root.data, result)) {
//            result.add(root.data);
//            return true;
//        }
//
//        return false;


        if (root == null) return  false;
        if (root.left == null && root.right == null) {
            if (root.data == sum) {
                result.add(root.data);
                return true;
            }

            else return false;
        }

        if (rootToLeafSum(root.left, sum-root.data, result)) {
            result.add(root.data);
            return true;
        }

        if (rootToLeafSum(root.right, sum-root.data, result)) {
            result.add(root.data);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        RootToLeafSum s1 = new RootToLeafSum();
        t1.root = new Node(10);
        t1.root.left = new Node(8);
        t1.root.right = new Node(2);
        t1.root.left.left = new Node(3);
        t1.root.left.right = new Node(5);
        t1.root.right.right = new Node(4);
        List<Integer> result = new ArrayList<>();
        System.out.println(s1.rootToLeafSum(t1.root, 16, result));
        System.out.println(result);
    }
}
