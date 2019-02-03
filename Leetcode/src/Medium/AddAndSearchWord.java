package Medium;

public class AddAndSearchWord {

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
        if (index == word.length && node.isLeaf == true) return true;
        if (word[index] == '.') {
            return node.children[index-'a'] != null && search(word, index+1, node.children[index-'a']);
        } else {
            char c = word[index];
            return node.children[c-'a'] !=null && search(word, index+1, node.children[c-'a']);
        }
    }
    public static void main(String[] args) {
        AddAndSearchWord w = new AddAndSearchWord();
        w.addWord("bad");
        w.addWord("dad");
        System.out.println(w.root);
        System.out.println(w.search("b.."));
    }
}
