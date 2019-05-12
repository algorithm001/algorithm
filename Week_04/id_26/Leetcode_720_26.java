package com.fanlu.leetcode.trietree;

import java.util.ArrayDeque;
import java.util.Deque;

// Source : https://leetcode.com/problems/longest-word-in-dictionary/
// Id     : 720
// Author : Fanlu Hai
// Date   : 2018-05-12
// Other  :
// Tips   :
public class LongestWordInDictionary {
    TrieNode root = new TrieNode("/");
//    String longest = null;

    public void insert(String string) {
        TrieNode node = root;
        for (int i = 0; i < string.length(); i++) {
            int index = string.charAt(i) - 'a';
            if (null == node.children[index]) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
        node.word = string;
    }

    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }
        Deque<TrieNode> st = new ArrayDeque<>();
        st.push(root);
        String best = "";

        while (!st.isEmpty()) {
            TrieNode nd = st.pop();
            if (nd.word != null && nd.word.length() > best.length())
                best = nd.word;
            if (null == nd.children)
                continue;
            for (char c = 'z'; c != 'a' - 1; --c) {
                TrieNode ch = nd.children[c - 'a'];
                if (null == ch || ch.word == null)
                    continue;
                st.push(ch);
            }
        }
        return best;
    }

    public class TrieNode {
        public String word;
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;

        public TrieNode(String word) {
            this.word = word;
        }

        public TrieNode() {

        }

    }
}
