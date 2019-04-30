import java.util.HashMap;

public class LeetCode_242_129 {
    //[aa] [bb]
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer count = hashMap.get(ch);
            if (count == null) {
                hashMap.put(ch, 1);
            } else {
                hashMap.put(ch, count + 1);
            }
        }
        for (char ch : t.toCharArray()) {
            Integer count = hashMap.get(ch);
            if (count == null || count <= 0) {
                return false;
            } else {
                hashMap.put(ch, count - 1);
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            int index = ch - 'a';
            if (arr[index] <= 0) {
                return false;
            } else {
                arr[index]--;
            }
        }
        return true;
    }

}
