class Solution {

    private class TrieNode {
        char data;
        TrieNode[] children;
        boolean isVisited = false;

        private TrieNode(char data) {
            this.data = data;
        }
    }

    private void insert(TrieNode root, char[] word) {
        TrieNode p = root;
        for (int i = 0; i < word.length; i++) {
            int index = word[i] - 'a';
            if (p.children == null) {
                p.children = new TrieNode[26];
            }
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(word[i]);
            }
            p = p.children[index];
        }
        p.isVisited = true;
    }

    private static String find(TrieNode node) {
        StringBuilder sb = new StringBuilder();
        if (node == null || !node.isVisited) {
            return "";
        }
        if (node.data >= 'a' && node.data <= 'z') {
            sb.append(node.data);
        }
        String longestWord = "";
        if (node.children != null) {
            for (TrieNode child : node.children) {
                if (child != null) {
                    String str = find(child);
                    if (str.length() > longestWord.length()) {
                        longestWord = str;
                    }
                }
            }
        }
        sb.append(longestWord);
        return sb.toString();
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        TrieNode root = new TrieNode('/');
        root.isVisited = true;
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i].toCharArray());
        }
        return find(root);
    }
}