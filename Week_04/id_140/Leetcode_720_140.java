/**
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 *
 * If there is no answer, return the empty string.
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2:
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 * Note:
 *
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 */
public class Leetcode_720_140 {

    class TrieNode{
        char val;
        TrieNode[] next;
        boolean isWord;
        TrieNode(char val){
            this.val = val;
            next = new TrieNode[26];
            isWord = false;
        }
    }
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode(' ');
        for(String str: words){
            buildTree(root, str);
        }
        int max = 0;
        int index = -1;
        for(int i = 0; i < words.length; i++){
            String str = words[i];
            boolean flag = findWord(root, str);
            if(flag && str.length() > max){
                max = str.length();
                index = i;
            }
            if(flag && str.length() == max){
                String old = words[index];
                index = str.compareTo(old) < 0 ? i : index;
            }
        }
        return words[index];
    }
    private void buildTree(TrieNode root, String str){
        for(char c : str.toCharArray()){
            if(root.next[c - 'a'] == null){
                root.next[c - 'a'] = new TrieNode(c);
            }
            root = root.next[c - 'a'];
        }
        root.isWord = true;
    }
    private boolean findWord(TrieNode root, String str){
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(root.next[c - 'a'] == null){
                return false;
            }
            root = root.next[c - 'a'];
            if(!root.isWord) {
                return false;
            }
        }
        return true;
    }

}
