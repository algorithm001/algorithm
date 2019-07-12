public class Leetcode242_143 {
    public boolean isAnagram(String s, String t) {
        int[] sCounts=new int[26];
        int[] tCounts=new int[26];

        for(char ch:s.toCharArray()){
            sCounts[ch-'a']++;
        }

        for(char ch:t.toCharArray()){
            tCounts[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(sCounts[i]!=tCounts[i]){
                return false;
            }
        }
        return true;
    }
}
