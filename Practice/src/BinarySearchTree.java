public class BinarySearchTree {

    private boolean binarySearch(Node root, int val) {
        if (root.data == val) return true;
        else if (val <= root.data) {
            return binarySearch(root.left, val);
        } else if (val >= root.data) {
            return binarySearch(root.right, val);
        }

        return false;
    }

    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        BinarySearchTree b1 = new BinarySearchTree();
        t1.root = new Node(10);
        t1.root.left = new Node(-5);
        t1.root.left.left = new Node(-10);
        t1.root.left.right = new Node(0);
        t1.root.left.right.right = new Node(5);
        t1.root.right = new Node(30);
        t1.root.right.right = new Node(36);

        System.out.println(b1.binarySearch(t1.root, 0));
    }
}

