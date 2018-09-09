class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left=right=null;
    }
}

class BinaryTree {
    Node root;
    BinaryTree() {
        root = null;
    }
    BinaryTree(int val) {
        root = new Node(val);
    }

    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(10);
        t1.root.left = new Node(2);
        t1.root.left.left = new Node(6);
        t1.root.right = new Node(5);
        t1.root.right.left = new Node(8);
        t1.root.right.right = new Node(3);
    }
}