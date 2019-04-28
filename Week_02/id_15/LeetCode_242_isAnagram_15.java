package com.haotone.week_01;

import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sarr = s.toCharArray();
		char[] tarr = t.toCharArray();
		HashMap<Character,Integer> dic = new HashMap<Character,Integer>();
		if(sarr.length != tarr.length) return false;
		for(int i=0;i<sarr.length;i++){
			char c = sarr[i];
			if(dic.containsKey(c)) dic.put(c, dic.get(c)+1);
			else dic.put(c, 1);
		}
		for(int i=0;i<tarr.length;i++){
			char c = tarr[i];
			if(dic.containsKey(c)){
				dic.put(c, dic.get(c)-1);
				if(dic.get(c)==0) dic.remove(c);
			} 
			else return false;
		}
		if(dic.size()>0) return false;
		return true;
        
    }
}