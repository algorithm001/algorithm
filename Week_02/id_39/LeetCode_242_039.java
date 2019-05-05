
import java.util.HashMap;
import java.util.Map;

/**
  * 
  * @author Paula
  *
  * 
  */
 
class Solution {
	private static void chechString(String s, Map<Character, Integer> smap) {
        for (int i = 0; i < s.length(); i++) {
            if (smap.containsKey(s.charAt(i))) {
                smap.put(s.charAt(i), smap.get(s.charAt(i)) + 1);
            } else {
                smap.put(s.charAt(i), 1);
            }
        }
    }

	public static boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        } else if (null == s || null == t || s.length() != t.length() || s.length() <= 0) {//如果长度不相等，直接返回
            return false;
        }
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        chechString(s, smap);
        for (int i = 0; i < t.length(); i++) {
        	char tmp = t.charAt(i);
            if (smap.containsKey(tmp)) {
                smap.put(tmp, smap.get(tmp) - 1);
            }
            if (0 == smap.get(tmp)) {
                smap.remove(tmp);
            }
        }
        
        return smap.size() == 0;
    }

	public static void main(String[] args) {
		//("anagram", new HashMap<Character, Integer>());
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
	}
}
