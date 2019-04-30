import java.util.HashMap;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/28
 */
public class LeetCode_242_108 {
    class Solution1 {
        public boolean isAnagram(String s, String t) {
            if(s == null || t == null || s.length() != t.length()){
                return false;
            }
            HashMap<Character,Integer> source = new HashMap<Character,Integer>();
            HashMap<Character,Integer> target = new HashMap<Character,Integer>();
            Integer count = null;
            Character c = null;
            for(int i=0 ; i< s.length() ; i ++){
                c = s.charAt(i);
                if(source.containsKey(c)){
                    count = source.get(c);
                    source.put(c,count + 1);
                }else{
                    source.put(c,1);
                }
            }

            for(int i=0 ; i< t.length() ; i ++){
                c = t.charAt(i);
                if(source.containsKey(c) && source.get(c) > 0){
                    count = source.get(c);
                    source.put(c,count - 1);
                }else{
                    target.put(c,1);
                }
            }

            return target.keySet().size() == 0;
        }
    }

    class Solution2 {
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
