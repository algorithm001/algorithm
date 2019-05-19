public class LeetCode_720_085 {
}


/**
 * @Package:
 * @ClassName: LongestWordInDictionary
 * @Description: 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * **************若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * **************若无答案，则返回空字符串。
 * @leetcode url:https://leetcode-cn.com/problems/longest-word-in-dictionary/
 * @Author: wangzhao
 * @Date: 2019-05-11 21:21:44
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class LongestWordInDictionary {

    private String longestWord="";
    public String longestWord(String[] words) {

        if (words == null || words.length == 0) {
            return null;
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        search(new StringBuffer(),trie.nodes);

        return longestWord;
    }

    private void search(StringBuffer sb,TreeNode4[] node4s) {
        if (node4s == null || node4s.length == 0) {
            return;
        }

        for (TreeNode4 node4 : node4s) {
            if (node4 != null && node4.end) {
                sb.append(node4.val);
                if (sb.length()>longestWord.length()){
                    longestWord=sb.toString();
                }
                search(sb,node4.children);
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }


    public static void main(String[] args) {
//        String[] words = {"w", "wo", "wor", "worl", "world"};
        String[] words= {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String longestWord = new LongestWordInDictionary().longestWord(words);
        System.out.println(longestWord);
    }
}

class Trie {

    TreeNode4[] nodes;

    public Trie() {
        this.nodes = new TreeNode4[26];
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        insert(0, word.toCharArray(), nodes);

    }

    private void insert(int i, char[] chars, TreeNode4[] children) {

        int idx = chars[i] - 'a';

        if (children[idx] == null) {
            children[idx] = new TreeNode4(chars[i]);
        }

        if (i == chars.length - 1) {
            children[idx].end = true;
            return;
        }

        if (children[idx].children == null) {
            children[idx].children = new TreeNode4[26];
        }

        insert(i + 1, chars, children[idx].children);
    }
}

class TreeNode4 {

    char val;
    boolean end;
    TreeNode4[] children;

    public TreeNode4(char val) {
        this.val = val;
    }
}
