public class IdenticalTrees {

    static int getMaxDepth(Node node) {
        if(node == null) return 0 ;
        int leftDepth = getMaxDepth(node.left);
        int rightDepth = getMaxDepth(node.right);
        return leftDepth > rightDepth ? leftDepth+1 : rightDepth+1;
    }

    static boolean areIdenticalTrees(Node a, Node b) {
     if (a == null && b == null) return true;

     if (a != null && b != null){
         return a.data == b.data &&
                 areIdenticalTrees(a.left, b.left) &&
                 areIdenticalTrees(a.right, b.right);
     }

     return false;

    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(1);
        t1.root.left = new Node(3);
        t1.root.right = new Node(2);
        t1.root.right.left = new Node(5);
        t1.root.right.right = new Node(4);

        BinaryTree t2 = new BinaryTree();
        t2.root = new Node(1);
        t2.root.left = new Node(3);
        t2.root.right = new Node(2);
        t2.root.right.left = new Node(5);
        t2.root.right.right = new Node(4);



        if(areIdenticalTrees(t1.root, t2.root)) System.out.println("Identical");
        else System.out.println("Not Identical");

    }
}
