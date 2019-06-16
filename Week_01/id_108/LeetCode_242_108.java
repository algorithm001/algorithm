/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/26
 */
public class LeetCode_242_108 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s == null || t == null || s.length() != t.length()){
                return false;
            }
            if(s.equals("") && t.equals("")){
                return true;
            }
            int[] arr = new int[26];
            for(int i = 0; i<s.length() ; i++){
                arr[s.charAt(i) - 'a'] ++;
                arr[t.charAt(i) - 'a'] --;
            }
            for(int i = 0;i<arr.length; i++){
                if(arr[i] != 0){
                    return false;
                }
            }

            return true;
        }
    }
}
