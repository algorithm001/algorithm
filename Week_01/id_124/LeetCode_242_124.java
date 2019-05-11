import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public boolean isAnagramByMap(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> cMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            Integer cnt = cMap.getOrDefault(c, 0);
            cMap.put(c, cnt + 1);
        }
        for (Character c : t.toCharArray()) {
            if (!cMap.containsKey(c)) {
                return false;
            }
            Integer cnt = cMap.getOrDefault(c, 0);
            cMap.put(c, cnt - 1);
        }
        for (Integer cnt : cMap.values()) {
            if (cnt > 0) {
                return false;
            }
        }
        return true;
    }

}
