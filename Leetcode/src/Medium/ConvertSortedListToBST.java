package Medium;

public class ConvertSortedListToBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head, fast = head, prev = null;
        while (fast != null  && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null;
        else head = null;
        TreeNode root = new TreeNode(slow.val);
        ListNode start = head;
        root.left = sortedListToBST(start);
        start = slow.next;
        root.right = sortedListToBST(start);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedListToBST t = new ConvertSortedListToBST();
        ListNode head = new ListNode(-10);
        head.next =  new ListNode(-3);
        head.next.next =  new ListNode(0);
        head.next.next.next =  new ListNode(5);
        head.next.next.next.next =  new ListNode(9);

        TreeNode root = t.sortedListToBST(head);
        System.out.println(root);
        System.out.println("DONE");
    }
}

/*
 public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf = false;
    }

    public TrieNode root = new TrieNode();

    public AddAndSearchWord () {

    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c :  word.toCharArray()) {
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }

        node.isLeaf = true;
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    public boolean search(char[] word, int index, TrieNode node) {
        if (index == word.length) return node.isLeaf;
        if (word[index] == '.') {
            for (int i = 0; i < node.children.length; i++)
                if (node.children[i] != null && search(word, index + 1, node.children[i]))
                    return true;
            return false;
        } else {
            char c = word[index];
            return node.children[c-'a'] !=null && search(word, index+1, node.children[c-'a']);
        }
    }
 */