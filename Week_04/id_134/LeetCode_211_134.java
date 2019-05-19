class WordDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() <= 0)
            return;
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            int pos = ch - 'a';
            if (node.sons[pos] == null) {
                node.sons[pos] = new TrieNode(ch);
            }
            node = node.sons[pos];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return patternSearch(word, root);
    }

    public boolean patternSearch(String word, TrieNode node) {
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            int pos = ch -'a';
            if (ch != '.') {
                if (node != null && node.sons[pos] != null) {
                    node = node.sons[pos];
                } else return false;
            } else {
                int cnt = 0;
                for (int j=0; j<26; j++) {
                    if (node.sons[j] != null) {
                        if (patternSearch(word.substring(i+1), node.sons[j])) return true;
                        else cnt ++;
                    } else {
                        cnt ++;
                        continue;
                    }
                }
                if (cnt == 26) return false;
            }
        }
        return node.isEnd;
    }

    class TrieNode {
        char val;
        boolean isEnd;
        TrieNode[] sons;
        public TrieNode() {
            isEnd = false;
            sons = new TrieNode[26];
        }
        public TrieNode(char val) {
            this.val = val;
            isEnd = false;
            sons = new TrieNode[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
