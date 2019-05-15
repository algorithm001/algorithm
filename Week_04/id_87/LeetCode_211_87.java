

/**
* Design a data structure that supports the following two operations:
*
* void addWord(word)
* bool search(word)
* search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
*
* Example:
*
* addWord("bad")
* addWord("dad")
* addWord("mad")
* search("pad") -> false
* search("bad") -> true
* search(".ad") -> true
* search("b..") -> true
* Note:
* You may assume that all words are consist of lowercase letters a-z.
*
*/
class WordDictionary {

    private final  int SIZE = 26;

    private class Node {
        boolean hasWord;
        Node[] chilren;
        public Node() {
            chilren = new Node[26];
        }
    }

    
    private Node root;
    /** Initialize your data structure here.
     *
     * Medium
     * https://leetcode.com/problems/add-and-search-word-data-structure-design/
     */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root = insert(word, root, 0);
    }

    private Node insert(String word, Node x, int d) {
        if (x == null) x = new Node();
        if (d == word.length()) {
            x.hasWord = true;
            return x;
        }
        char c = word.charAt(d);
        x.chilren[c - 'a'] = insert(word, x.chilren[c - 'a'], d + 1);
        return x;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String pat, Node x, int d) {
        if (x == null) return false;
        if (d == pat.length()) return x.hasWord;
        char next = pat.charAt(d);
        boolean ans = false;
        for (char c = 0; c < 26; c++) {
            if (next == '.' || c == next - 'a') {
                ans = ans || search(pat, x.chilren[c], d + 1);
            }
        }
        return ans;
    }

}