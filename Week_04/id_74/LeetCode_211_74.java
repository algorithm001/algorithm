class WordDictionary {
    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('/');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode n = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (n.children[index] == null) {
                n.children[index] = new TrieNode(c);
            }
            n = n.children[index];
        }
        n.isEndingChar = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word, 0, root);
    }
    
    private boolean match(String word, int start, TrieNode node) {
        if (start == word.length()) {
            return node.isEndingChar;
        }
        
        char c = word.charAt(start);
        if (c == '.') {
            for (TrieNode n : node.children) {
                if (n != null) {
                    if (match(word, start + 1, n)) {
                        return true;
                    }
                }
            }
        } else {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            return match(word, start + 1, node.children[c - 'a']);
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */