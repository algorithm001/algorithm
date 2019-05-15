//242. valid-anagram(哈希表-简单)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] str = new int[26];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            str[index]++;
        }
        for(int j = 0; j < t.length(); j++){
            int index = t.charAt(j) - 'a';
            if(str[index]-- == 0){
                return false;
            }
        }
        return true;
    }
}
