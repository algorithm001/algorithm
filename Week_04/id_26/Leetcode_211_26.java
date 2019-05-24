package com.fanlu.leetcode.trietree;

// Source : https://leetcode.com/problems/add-and-search-word-data-structure-design/
// Id     : 211
// Author : Fanlu Hai
// Date   : 2018-05-12
// Other  :
// Tips   :

public class WordDictionary {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfAWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    // 100.00%  76.32% (54.9)
    public boolean search(String word) {
        return search(root, word, 0);
    }

    // compare each node's children with the char at the given index of the word incrementally
    public boolean search(TrieNode node, String word, int index) {
        // if index is already longer than max index (length-1)
        // then check if the node is the end of an work, there's no need to check its children
        if (index == word.length()) {
            return node.isEndOfAWord;
        }

        char ch = word.charAt(index);
        index++;

        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (child != null) {
                    // if this child works then return true
                    if (search(child, word, index)) {
                        return true;
                    }
                }
            }
            // no child's path works.
            return false;
        } else {
            if (node.children[ch - 'a'] != null) {
                return search(node.children[ch - 'a'], word, index);
            } else {
                return false;
            }
        }
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndOfAWord = false;

    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
//        obj.addWord("at");
        obj.addWord("and");
//        obj.addWord("an");
        obj.addWord("add");
//        obj.addWord("a");
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("a.d"));
        System.out.println(obj.search("b."));
        System.out.println(obj.search("...."));
        System.out.println(obj.search(".."));
        System.out.println(obj.search("a.d."));
        System.out.println(obj.search(".ad"));
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */