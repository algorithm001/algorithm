package com.fanlu.leetcode.trietree;

import java.util.HashMap;
import java.util.Stack;

// Source : https://leetcode.com/problems/longest-word-in-dictionary/
// Id     : 720
// Author : Fanlu Hai
// Date   : 2018-05-12
// Other  : data structure of the children list will affect the performance significantly
// Tips   : good test case ["gbra","jy","pl","zn","gb","j","jyh","jyhm","plr","znicn","p","gbr","zni","znic","aq"]
public class LongestWordInDictionary {
    TrieNodeUsingMap rootNodeUsingMap = new TrieNodeUsingMap('/');
    TrieNodeUsingArray rootNodeUsingArray = new TrieNodeUsingArray('/');
    String longest = "";


    // 34.81%(22 ms) 97.45%
    public String longestWordSlow(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insertUsingMap(words[i], i);
            // System.out.println("insertUsingMap: " + i + " " + words[i]);
        }

        Stack<TrieNodeUsingMap> stack = new Stack();
        stack.addAll(rootNodeUsingMap.children.values());

        TrieNodeUsingMap node;
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
    public String longestWordBetter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insertUsingMap(words[i], i);
            // System.out.println("insertUsingMap: " + i + " " + words[i]);
        }
        for (TrieNodeUsingMap child : rootNodeUsingMap.children.values()) {
            searchLongest(child, words);
        }
        return longest;
    }

    public void searchLongest(TrieNodeUsingMap node, String[] words) {
        if (node.index != -1) {
            String tmp = words[node.index];
            // System.out.println("check "+tmp);
            if (tmp.length() > longest.length()
                    || (tmp.length() == longest.length() && tmp.compareTo(longest) < 0)) {
                // System.out.println("longest "+tmp);
                longest = tmp;
            }
            for (TrieNodeUsingMap child : node.children.values()) {
                searchLongest(child, words);
            }
        }
    }

    //97.79% (6 ms) 97.18% (37.6 MB)
    public String longestWord(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insertUsingArray(words[i], i);
            System.out.println("insert: " + i + " " + words[i]);
        }
        for (TrieNodeUsingArray child : rootNodeUsingArray.children) {
            if (null != child)
                searchLongest2(child, words);
        }
        return longest;
    }

    public void searchLongest2(TrieNodeUsingArray node, String[] words) {

        if (node.index != -1) {
            String tmp = words[node.index];
            // System.out.println("check "+tmp);
            if (tmp.length() > longest.length()
                    || (tmp.length() == longest.length() && tmp.compareTo(longest) < 0)) {
                System.out.println("longest " + tmp);
                longest = tmp;
            }
            for (TrieNodeUsingArray child : node.children) {
                if (null != child)
                    searchLongest2(child, words);
            }
        }
    }

    class TrieNodeUsingMap {
        public char c;
        // to keep track which word's insertion created this node
        public int index = -1;
        HashMap<Character, TrieNodeUsingMap> children = new HashMap();

        public TrieNodeUsingMap(char c) {
            this.c = c;
        }

        public TrieNodeUsingMap(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public void insertUsingMap(String string, int index) {
        TrieNodeUsingMap node = rootNodeUsingMap;
        for (char c : string.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNodeUsingMap(c));
            node = node.children.get(c);
        }
        // not only means this node is the end of a word,but also contains index information for this word.
        node.index = index;
    }

    class TrieNodeUsingArray {
        public char c;
        // to keep track which word's insertion created this node
        public int index = -1;
        TrieNodeUsingArray[] children = new TrieNodeUsingArray[26];

        public TrieNodeUsingArray(char c) {
            this.c = c;
        }

        public TrieNodeUsingArray(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public void insertUsingArray(String string, int index) {
        TrieNodeUsingArray node = rootNodeUsingArray;
        for (char c : string.toCharArray()) {
            int n = c - 'a';
            if (node.children[n] == null) {
                node.children[n] = new TrieNodeUsingArray(c);
            }
            node = node.children[n];
        }
        node.index = index;
    }
}
