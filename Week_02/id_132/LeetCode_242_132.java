class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int [] arr = new int [26];
        boolean flag = false;
        for (char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        
        for (char d : t.toCharArray()){
            if (arr[d - 'a'] == 0) return flag;
            arr[d - 'a']--;
        }
        
        return true;
    }
}