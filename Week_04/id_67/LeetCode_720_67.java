class Solution {
    String longestword = "";
    int longlen = 0;

    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            if (trie.isBuild(word) && word.length() > longlen) {
                longestword = word;
                longlen = word.length();
            } else if (trie.isBuild(word) && word.length() == longlen) {
                char[] longestchar = longestword.toCharArray();
                char[] wordchar = word.toCharArray();
                for (int i = 0; i < longlen; i++) {
                    if (wordchar[i] - longestchar[i] < 0) {
                        longestword = word;
                        break;
                    } else if (wordchar[i] - longestchar[i] > 0) break;
                }
            }
        }
        return longestword;

    }

    class TrieNode {
        public char data;
        public boolean isword = false;
        public TrieNode[] next = new TrieNode[26];

        public TrieNode(char c) {
            data = c;
        }
    }

    class Trie {
        TrieNode root = new TrieNode('/');

        public void insert(String string) {
            char[] ccc = string.toCharArray();
            TrieNode p = root;
            for (int i = 0; i < ccc.length; i++) {
                int index = ccc[i] - 'a';
                if (p.next[index] == null) {
                    TrieNode trienode = new TrieNode(ccc[i]);
                    p.next[index] = trienode;
                }
                p = p.next[index];
            }
            p.isword = true;
        }

        public boolean isBuild(String string) {
            char[] ccc = string.toCharArray();
            TrieNode p = root;
            for (int i = 0; i < ccc.length; i++) {
                if (!p.next[ccc[i] - 'a'].isword) return false;
                p = p.next[ccc[i] - 'a'];
            }
            return true;
        }

    }

}