class Solution {
    TrieNode root = new TrieNode();
    StringBuilder curWord = new StringBuilder();
    String ret = null;
    public String longestWord(String[] words) {
        if (words == null)
            return null;
        for (String word : words) {
            insert(word);
        }
        traverse(root);
        return ret;
    }

    public void traverse(TrieNode root) {
        if (root.isLeaf()) {
            if (curWord != null) {
                if (ret == null || ret.length() < curWord.length() || 
                     (ret.length() == curWord.length() && ret.compareTo(curWord.toString()) > 0)) {
                    ret = curWord.toString();
                }
            }
            return;
        }
        for (int i=0; i<26; i++) {
            if (root.sons[i] != null && root.sons[i].isEnd) {
                curWord.append(root.sons[i].val);
                traverse(root.sons[i]);
                curWord.deleteCharAt(curWord.length()-1);
            }
        }
    }

    public void insert(String word) {
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
        public boolean isLeaf() {
            boolean leafFlag = true, endFlag = true;
            for (int i=0; i<sons.length; i++) {
                if (sons[i] != null) {
                    leafFlag = false;
                    if (sons[i].isEnd) {
                        endFlag = false;
                    }
                }
            }
            return leafFlag || endFlag;
        }
    }
}
