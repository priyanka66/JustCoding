import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {

        static boolean hasSumPath(Node root, int sum, List<Integer> result) {
            if (root == null) return false;
            if (root.left == null && root.right == null) {
                if (root.data == sum) return true;
                else return false;
            }

            if(hasSumPath(root.left, sum-root.data, result)) {
                result.add(root.data);
                return true;
            }
            if(hasSumPath(root.right, sum-root.data, result)){
                result.add(root.data);
                return true;
            }

            return false;

        }
        public static void main(String[] args) {
            int sum = 21;
            BinaryTree t1 = new BinaryTree();
            List<Integer> result = new ArrayList<>();
            t1.root = new Node(10);
            t1.root.left = new Node(8);
            t1.root.right = new Node(2);
            t1.root.left.left = new Node(3);
            t1.root.left.right = new Node(5);
            t1.root.right.right = new Node(4);


            if(hasSumPath(t1.root, sum, result)) System.out.println("Has Path");
            else System.out.println("NoPath");

        }

}
