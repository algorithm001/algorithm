package com.fanlu.leetcode.trietree;

import java.util.HashMap;
import java.util.Stack;

// Source : https://leetcode.com/problems/longest-word-in-dictionary/
// Id     : 720
// Author : Fanlu Hai
// Date   : 2018-05-12
// Other  : children list will affect the performance
// Tips   :
public class LongestWordInDictionary {
    TrieNode root = new TrieNode('/');
    String longest = "";

    public void insert(String string, int index) {
        TrieNode node = root;
        for (char c : string.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode(c));
            node = node.children.get(c);
        }
        // not only means this node is the end of a word,but also contains index information for this word.
        node.index = index;
    }

    // 34.81%(22 ms) 97.45%
    public String longestWordSlow(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
            // System.out.println("insert: " + i + " " + words[i]);
        }

        Stack<TrieNode> stack = new Stack();
        stack.addAll(root.children.values());

        TrieNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            // System.out.println(node.c+" "+node.index);
            if (node.index != -1) {
                String tmp = words[node.index];
                // System.out.println("check "+tmp);
                if (tmp.length() > longest.length()
                        || (tmp.length() == longest.length() && tmp.compareTo(longest) < 0)) {
                    // System.out.println("longest "+tmp);
                    longest = tmp;
                }
                stack.addAll(node.children.values());
            }

        }

        return longest;
    }

    //51.26% (16 ms) 98.36%
    public String longestWord(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
            // System.out.println("insert: " + i + " " + words[i]);
        }
        for (TrieNode child : root.children.values()) {
            searchLongest(child, words);
        }
        return longest;
    }

    public void searchLongest(TrieNode node, String[] words) {
        if (node.index != -1) {
            String tmp = words[node.index];
            // System.out.println("check "+tmp);
            if (tmp.length() > longest.length()
                    || (tmp.length() == longest.length() && tmp.compareTo(longest) < 0)) {
                // System.out.println("longest "+tmp);
                longest = tmp;
            }
            for (TrieNode child : node.children.values()) {
                searchLongest(child, words);
            }
        }
    }

    class TrieNode {
        public char c;
        // to keep track which word's insertion created this node
        public int index = -1;
        HashMap<Character, TrieNode> children = new HashMap();

        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }
}
