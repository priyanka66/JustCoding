public class SumRootToLeaf {

        static boolean hasSumPath(Node node, int sum) {
            if (node == null) {
                return sum == 0;
            } else {
                boolean hasPath = false;
                int nodeSum = sum - node.data;
                if (nodeSum == 0 && node.left == null && node.right == null) return true;
                if (node.left != null) return hasPath || hasSumPath(node.left, nodeSum);
                if (node.right != null) return hasPath || hasSumPath(node.right, nodeSum);
            }
            return  false;

        }
        public static void main(String[] args) {
            int sum = 21;
            BinaryTree t1 = new BinaryTree();
            t1.root = new Node(10);
            t1.root.left = new Node(8);
            t1.root.right = new Node(2);
            t1.root.left.left = new Node(3);
            t1.root.left.right = new Node(5);
            t1.root.right.right = new Node(4);


            if(hasSumPath(t1.root, sum)) System.out.println("Has Path");
            else System.out.println("NoPath");

        }

}
