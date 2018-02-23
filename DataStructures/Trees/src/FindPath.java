import java.util.ArrayList;
import java.util.List;

public class FindPath {

    List<Integer> path1 = new ArrayList<>();
    List<Integer> path2 = new ArrayList<>();
    int findLCA(Node root, int n1, int n2) {
        if (!findPathTo(root, n1, path1) || !findPathTo(root, n2, path2)) {
            System.out.println("No LCA");
            return -1;
        }

        int i;
        for (i =0 ;i < path1.size() && i < path2.size() ; i++){
            if(!path1.get(i).equals(path2.get(i))) break;
        }

        return path1.get(i-1);
    }

    boolean findPathTo(Node root, int num, List<Integer> path){
        if (root == null) return true;
        path.add(root.data);
        if (root.data == num) return true;
        if (root.left != null && findPathTo(root.left, num, path)) return true;
        if (root.right != null && findPathTo(root.right, num, path)) return true;

        path.remove(path.size()-1);
        return false;
    }

    public Node findLCASingleTraversal(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 && root.data == n2) return root;

        Node left = findLCASingleTraversal(root.left, n1, n2);
        Node right = findLCASingleTraversal(root.right, n1, n2);

        if (left != null && right != null) return root;

        return (left != null) ? left : right;

    }

    public static void main(String[] args) {
        FindPath f1 = new FindPath();
        BinaryTree t1 = new BinaryTree();
        t1.root = new Node(1);
        t1.root.left = new Node(2);
        t1.root.right = new Node(3);
        t1.root.left.left = new Node(4);
        t1.root.left.right = new Node(5);
        t1.root.right.left = new Node(6);
        t1.root.right.right = new Node(7);

        System.out.println("LCA of (4,5) " + f1.findLCA(t1.root, 4, 5));
//        System.out.println("LCA of (4,5) " + f1.findLCASingleTraversal(t1.root, 4, 5).data);
    }
}
