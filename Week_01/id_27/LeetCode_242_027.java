class Solution {
    public boolean isAnagram(String s, String t) {

    	if(null == s || null == t) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        if(sArr.length != tArr.length) return false;
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for(int i=0;i<sArr.length;i++) {
        	if(sArr[i] != tArr[i]) return false;
        }

        return true;

    }
}
