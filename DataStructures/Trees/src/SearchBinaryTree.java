public class SearchBinaryTree {


    Node searchBinary(Node node, int key) {
        if (node == null) return null;
        if (node.data == key) return node;
        else if (key < node.data) return searchBinary(node.left, key);
        else return searchBinary(node.right, key);
    }
    public static void main(String[] args) {
        SearchBinaryTree s1 = new SearchBinaryTree();
        BinaryTree t1 = new BinaryTree();
        int key = 5;
        t1.root = new Node(10);
        t1.root.left = new Node(-5);
        t1.root.right = new Node(25);
        t1.root.left.left = new Node(-10);
        t1.root.left.right = new Node(5);
//        t1.root.right.left = new Node();
        t1.root.right.right = new Node(36);
        System.out.println(s1.searchBinary(t1.root, key).data);

    }

}
