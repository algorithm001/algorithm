package leetCode.week4;

/**
 * Trie
 */
class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    Trie() {
        root = new TrieNode();
        root.val = ' ';
    }
    
    /** Inserts a word into the trie. */
    void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    boolean search(String word) {
        return wordLoop(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    boolean startsWith(String prefix) {
        wordLoop(prefix);
        return true;

    }

    private boolean wordLoop(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return true;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    class TrieNode {
        public char val;
        TrieNode[] children = new TrieNode[26];
        boolean isWord;

        TrieNode(){}

        TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val  = c;
        }
    }
}