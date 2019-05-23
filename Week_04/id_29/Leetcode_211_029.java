package leetcode.Algorithms._201_300._211_AddAndSearchWordDataStructureDesign;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jialei.zou on 2019/5/11 .
ref:
 https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/

 设计一个支持以下两种操作的数据结构：

 void addWord(word)
 bool search(word)
 search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。

 示例:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 说明:

 你可以假设所有单词都是由小写字母 a-z 组成的。
 */
public class AddAndSearchWordDataStructureDesign {

    /**
     * 看到题目的反应是
     * set及方法contains，但是解决不了正则匹配的问题
     *
     * 之后看王争老师的trie章节了，《35 | Trie树：如何实现搜索引擎的搜索关键词提示功能？》
     * 写的
     * 参考方法里面用的back-tracking+trie
     * 在item里面写的word解决了2个问题
     * 1. 不用遍历所有的，只要找到了一个就进行了返回（所以时间上回快）
     * 2. 在末端保存了word，在路径这没有保存value，只是保存了引用，通用性不错，也解决了第一次word为""的情况
     */

    private Node myRoot;
    /** Initialize your data structure here. */
    public AddAndSearchWordDataStructureDesign() {
        myRoot = new Node('/');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] words = word.toCharArray();
        Node p = myRoot;
        for (char item: words){
            int index = item - 'a';
            if(p.children[index] == null){
                p.children[index] = new Node(item);
            }
            p = p.children[index];
        }
        p.isLastNode = true;
    }

    /**
     * 逐层遍历
     */
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] words = word.toCharArray();
        //curParents表示当下这一层，有多少个符合的节点
        Queue<Node> curParents = new LinkedList<>();

        curParents.add(myRoot);
        for (char item: words){
           int size = curParents.size();
           for (int i=0; i<size; i++){
               Node parent = curParents.poll();
               if(item == '.'){
                   Node[] children = parent.children;
                   for (Node childrenNode: children){
                       if (childrenNode != null){
                           curParents.offer(childrenNode);
                       }
                   }
               }else {
                   int index = item-'a';
                   if(parent.children[index]!=null){
                       curParents.offer(parent.children[index]);
                   }
               }
           }
           //如果当下这一层没有符合的节点，则说明匹配失败，返回
           if(curParents.isEmpty()){
               return false;
           }
        }
        //查看是否为叶子节点
        while (!curParents.isEmpty()){
            Node node = curParents.poll();
            if(node.isLastNode){
                return true;
            }
        }
        return false;
    }

    public class Node{
        public Node[] children = new Node[26];
        boolean isLastNode;
        char value;
        public Node(char value){
            this.value = value;
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
    public static void main(String[] args) {
        AddAndSearchWordDataStructureDesign obj = new AddAndSearchWordDataStructureDesign();
        obj.addWord("abc");
        System.out.println(obj.search("abc"));
        System.out.println(obj.search("ab"));
        System.out.println(obj.search(".bc"));
        System.out.println(obj.search("..."));
        System.out.println(obj.search(".."));




    }

    /**
     *给的参考里面用到了backtracking和trie
     *
     */
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    private TrieNode root = new TrieNode();

    public void addWordRef(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    public boolean searchRef(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) {
            return !node.item.equals("");
        }
        if (chs[k] != '.') {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}






