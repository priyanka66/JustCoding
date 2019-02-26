package Medium;

public class AddAndSearchWord {

   public class TrieNode {
       TrieNode[] children = new TrieNode[26];
       boolean isLeaf = false;
   }

    public TrieNode root = new TrieNode();
    public AddAndSearchWord() {
    }

    public void addWord(String word) {
        TrieNode node = root;
        addWord(word.toCharArray(), 0, node);
    }

    public void addWord(char[] word, int index, TrieNode node) {
        if (index ==  word.length) {
            node.isLeaf = true;
            return;
        }
        char c = word[index];
        if (node.children[c-'a'] ==  null)
            node.children[c-'a'] = new TrieNode();

        addWord(word, index+1, node.children[c-'a']);
    }

    public boolean search(String word) {
        TrieNode node = root;
        return search(word.toCharArray(), 0, node);
    }

    public boolean search(char[] word, int index, TrieNode node) {
        if (index == word.length) return node.isLeaf;
        if (word[index] == '.') {
            for (int i=0;i<node.children.length;i++) {
                if (node.children[i] != null && search(word, index + 1, node.children[i]))
                    return true;
            }
        } else {
            char c = word[index];
            return node.children[c-'a'] != null && search(word, index+1, node.children[c-'a']);
        }

        return false;
    }
    public static void main(String[] args) {
        AddAndSearchWord w = new AddAndSearchWord();
        w.addWord("bad");
        w.addWord("dtad");

        System.out.println(w.root);

        System.out.println(w.search("d.ad"));
    }
}
