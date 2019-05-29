class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }else{                   
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();
            char[] chArr = new char[26];
            
            for(int i=0;i<sArr.length;i++){
                chArr[sArr[i] - 'a'] ++;
                chArr[tArr[i] - 'a'] --;          
            }
            
            for(int i=0 ;i < 26;i++){
                if(chArr[i] !=0 ){
                    return false;
                }
            }
            return true;      
            
        }
        
    }
}