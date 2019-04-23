class Solution {
    

    public boolean isAnagram(String s, String t) {
    	if(null == s || null == t) return false;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char sTmp:s.toCharArray()) {
        	map.put(sTmp, map.getOrDefault(sTmp, 0)+1);
        }

        for(char tTmp:t.toCharArray()) {
        	Integer cnt = map.get(tTmp);
        	if(cnt == null) {
        		return false;
        	}
        	else if(map.get(tTmp)==1) {
        		map.remove(tTmp);
        	}
        	else {
        		map.put(tTmp,cnt-1);
        	}
        }

        return map.isEmpty();
    }
}
