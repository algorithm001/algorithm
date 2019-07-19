class Solution {
    private String longestWord = "";

    public String longestWord(String[] words) {

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word.toCharArray());
        }

        searchLongestWord(new StringBuilder(), trie.root.children);
        return longestWord;
    }

    private void searchLongestWord(StringBuilder sb, Trie.TrieNode[] children) {
        if (children == null)
            return;
        for (Trie.TrieNode node : children) {
            if (node != null && node.isEndingChar) { // 该节点必须为某个单词的结束字符
                sb.append(node.data);
                if (sb.length() > longestWord.length())
                    longestWord = sb.toString();
                searchLongestWord(sb, node.children);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    class Trie {
        private TrieNode root = new TrieNode('/'); // 存储无意义字符

        // 往 Trie 树中插入一个字符串
        public void insert(char[] text) {
            TrieNode p = root;
            for (int i = 0; i < text.length; ++i) {
                int index = text[i] - 'a';
                if (p.children[index] == null) {
                    TrieNode newNode = new TrieNode(text[i]);
                    p.children[index] = newNode;
                }
                p = p.children[index];
            }
            p.isEndingChar = true;
        }

        // 在 Trie 树中查找一个字符串
        public boolean find(char[] pattern) {
            TrieNode p = root;
            for (int i = 0; i < pattern.length; ++i) {
                int index = pattern[i] - 'a';
                if (p.children[index] == null) {
                    return false; // 不存在 pattern
                }
                p = p.children[index];
            }
            if (p.isEndingChar == false)
                return false; // 不能完全匹配，只是前缀
            else
                return true; // 找到 pattern
        }

        class TrieNode {
            public char data;
            public TrieNode[] children = new TrieNode[26];
            public boolean isEndingChar = false;

            public TrieNode(char data) {
                this.data = data;
            }
        }
    }
}
