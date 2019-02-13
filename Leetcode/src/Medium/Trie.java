package Medium;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isLeaf = false;

    TrieNode() {
    }

}
public class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
         insert(word.toCharArray(), 0, root);
    }

    public void insert(char[] word, int index, TrieNode root) {
        if (index == word.length) {
            root.isLeaf = true;
            return;
        }
        char c = word[index];
        if (root.children[c-'a'] == null) {
            root.children[c-'a'] = new TrieNode();
        }
        root = root.children[c-'a'];
        insert(word, index+1, root);
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    public boolean search(char[] word, int index, TrieNode root) {
        if (index == word.length) return root.isLeaf;
        char c = word[index];

        return root.children[c-'a'] != null && search(word, index+1, root.children[c-'a']);
    }

    public boolean startsWith(String word) {
        return startsWith(word.toCharArray(), 0, root);
    }

    public boolean startsWith(char[] word, int index, TrieNode root) {
        if (index == word.length) return true;
        char c = word[index];

        return root.children[c-'a'] != null && search(word, index+1, root.children[c-'a']);

    }
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
