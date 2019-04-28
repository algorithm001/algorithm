class Solution {
    public boolean isAnagram(String s, String t) {
        int[] x =new int[26];

        for(char schar: s.toCharArray()){
            x[schar-'a']++;
        }
        for(char tchar: t.toCharArray()){
            x[tchar-'a']--;
        }
        for(int i=0;i<26;i++){
            if (x[i] != 0){
                return false;
            }
        }
        return true;
    }
}