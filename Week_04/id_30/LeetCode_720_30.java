package com.shufeng.algorithm4.demo;


import java.util.HashMap;
import java.util.Map;

/**
 * @author gsf
 * @date 2019-05-09 14:16
 */
public class LeetCode_720_30 {

    public static void main(String[] args) {
//        String[] words = {"w", "wo", "wor", "worl", "world"};
//        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words = {"b", "br", "bre", "brea", "break", "breakf", "breakfa", "breakfas", "breakfast", "l", "lu", "lun", "lunc", "lunch", "d",
                "di", "din", "dinn", "dinne", "dinner"};
        String s = longestWord(words);
        System.out.println(s);
    }


    public static String longestWord(String[] words) {
        Node node = new Node(true);
        for (int i = 0; i < words.length; i++) {
            add(node, words[i]);
        }
        String str = "";
        for (String word : words) {
            if (find(node, word) && (word.length() > str.length() || word.length() == str.length() && word.compareTo(str) < 0)) {
                str = word;
            }
        }
        return str;
    }

    private static class Node {
        // 是单词
        private boolean isword;
        // 每个字符有多个子字符
        private Map<Character, Node> next;

        public Node(boolean isword) {
            this.isword = isword;
            this.next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    /**
     * 查询字符串是否每加个字符都有
     */
    public static boolean find(Node node, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next.get(c) == null || !node.isword) {
                return false;
            }
            node = node.next.get(c);
        }

        return true;
    }

    public static void add(Node node, String word) {

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next.get(c) == null) {
                node.next.put(c, new Node());
            }
            node = node.next.get(c);
        }
        if (!node.isword) {
            node.isword = true;
        }
    }

}
