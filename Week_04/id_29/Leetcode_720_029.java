package leetcode.Algorithms._701_800._720_LongestWordInDictionary;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialei.zou on 2019/5/12 .
 ref:
 https://leetcode-cn.com/problems/longest-word-in-dictionary/


 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 若其中有多个可行的答案，则返回答案中字典序最小的单词。

 若无答案，则返回空字符串。

 示例 1:

 输入:
 words = ["w","wo","wor","worl", "world"]
 输出: "world"
 解释:
 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 示例 2:

 输入:
 words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 输出: "apple"
 解释:
 "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
 注意:

 所有输入的字符串都只包含小写字母。
 words数组长度范围为[1,1000]。
 words[i]的长度范围为[1,30]。
 */
public class LongestWordInDictionary {


    private int maxLength;
    String result;
    private Node root;
    public String longestWord(String[] words) {
        result = "";
        maxLength = 0;
        root = new Node('/');
        for (String item: words){
            add(item);
        }
        helper(root, new ArrayList<>());
        String curResult = result;
        return curResult;
    }

    /**
     *
     * @param node
     * @param list
     */
    private void helper(Node node, List<Character> list){
        //终止条件
        if(!node.haveChildren){
            return;
        }

        /**
         * 如果有孩子，且孩子也是word的最后一个字符，那么就比较
         */
        for (Node item: node.children){
            if(item != null && item.isLast){
                list.add(item.value);
                if(list.size()>maxLength){
                    maxLength = list.size();
                    result = "";
                    for(Character itemList: list){
                        result = result + itemList;
                    }

                }
                helper(item, list);
                list.remove(list.size()-1);
            }
        }
    }



    private void add(String word){
        char[] words = word.toCharArray();
        Node p = root;
        for (char item: words){
            int index = item - 'a';
            if(p.children[index] == null){
                p.children[index] = new Node(item);
            }
            p.haveChildren = true;
            p = p.children[index];
        }
        p.isLast = true;
    }

    private class Node{
        Node[] children = new Node[26];
        //是否后续还有字符
        boolean haveChildren;
        //有没有单词该位置就是最后一个元素
        boolean isLast;
        private char value;
        public Node(char c){
            this.value = c;
        }
    }

    public static void main(String[] args) {
        LongestWordInDictionary dictionary = new LongestWordInDictionary();
        System.out.println(dictionary.longestWord(new String[]{"w","wo","wor","worl", "world"}));
        System.out.println(dictionary.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(dictionary.longestWord(new String[]{"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"}));

    }
}
