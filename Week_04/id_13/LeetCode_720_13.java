package leetCode.week4;

/**
 * 词典中最长的单词
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 *
 * @author JP.Jiang
 * @version Java
 */

class Node {
    char val;
    boolean isWord;
    Node[] children;

    Node(char val) {
        this.val = val;
    }
}

class Trie2 {

    Node[] children;

    Trie2() {
        children = new Node[26];
    }

    void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        insert(0, word.toCharArray(), children);
    }

    private void insert(int l, char[] chars, Node[] children) {
        int i = chars[l] - 'a';
        if (children[i] == null) children[i] = new Node(chars[l]);

        if (l == chars.length - 1) {
            children[i].isWord = true; // 设置最后一个字符的结束标志
            return; // 最后一个字符的children=null
        }
        if (children[i].children == null) children[i].children = new Node[26];
        insert(l + 1, chars, children[i].children);
    }
}

class LeetCode_720_13 {

    private String longestWord = "";

    public String longestWord(String[] words) {
        Trie2 trie = new Trie2();

        for (String word : words) trie.insert(word);

        searchLongestWord(new StringBuilder(), trie.children);
        return longestWord;
    }

    private void searchLongestWord(StringBuilder sb, Node[] children) {
        if (children == null) return;
        for (Node node : children) {
            if (node != null && node.isWord) { // 该节点必须为某个单词的结束字符
                sb.append(node.val);
                if (sb.length() > longestWord.length())
                    longestWord = sb.toString();
                searchLongestWord(sb, node.children);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}