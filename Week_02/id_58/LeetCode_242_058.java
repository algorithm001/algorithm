package algorithm.Week_02.id_58;

/**
 * 242. Valid Anagram
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * 分析：
 * 所谓有效的字母异位词，就是字母类型和大小都一致，但是是不同的单词，这样的两个单词互为字母异位词
 * 分别用26个字母数组来存储两个字母串，最后对比两个数组即可，发现有不一致的则返回false，若同相同则返回true。
 * @auther: guangjun.ma 
 * @date: 2019/4/27 16:16
 * @version: 1.0
 */
public class LeetCode_242_058 {
    public boolean isAnagram(String s, String t) {
        //1、这里用一个26位的字符串数字做为存储介质，转化公式为 ch - 'a'
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];

        //2、存储s字符串
        for(char ch : s.toCharArray()){
            sCounts[ch - 'a'] ++;
        }

        //3、存储t字符串
        for(char ch : t.toCharArray()){
            tCounts[ch - 'a'] ++;
        }

        //4、比较两个字符串
        for (int i = 0; i < 26 ; i++){
            if(sCounts[i] != tCounts[i]){
                return false;
            }
        }

        return true;

    }
}
