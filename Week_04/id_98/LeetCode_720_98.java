import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class Solution {
    public String longestWord(String[] words) {
    	Arrays.sort(words);
    	Set<String> tmpSet = new HashSet<>();
    	String res = "";
    	for (String s : words) {
    		if (s.length() == 1 || tmpSet.contains(s.substring(0, s.length() - 1))) {
    			res = s.length() > res.length() ? s : res;
    			tmpSet.add(s);
    		}
    	}
    	return res;
    }
}