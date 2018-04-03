public class ChildSum {

    static boolean hasChildSum(Node node){
        int left=0, right =0;
       if ((node == null) || (node.left == null && node.right == null)) return true;
        else {
            if (node.left != null) {
                left = node.left.data;
            }
            if (node.right !=null){
                right = node.right.data;
            }

            if ((node.data == left+right) && hasChildSum(node.right) && hasChildSum(node.right)) return true;
            else return false;

       }
    }
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(10);
        t1.root.left = new Node(8);
        t1.root.right = new Node(2);
        t1.root.left.left = new Node(3);
        t1.root.left.right = new Node(5);
        t1.root.right.right = new Node(2);


        if(hasChildSum(t1.root)) System.out.println("Has child sum");
        else System.out.println("no child sum");

    }
}
