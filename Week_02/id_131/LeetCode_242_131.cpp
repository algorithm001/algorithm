/*
* 有效的字母异位词
* 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
* 输入: s = "anagram", t = "nagaram"  输出: true
* 输入: s = "rat", t = "car" 输出: false
*/

class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size()) return false;
        int strCount[26] = {0};
        for(int indexStr = 0; indexStr < s.size(); ++indexStr)
        {
            strCount[s[indexStr]-'a'] += 1;
            strCount[t[indexStr]-'a'] -= 1;
        }
        for(int indexC = 0; indexC < 26; ++indexC)
        {
            if(strCount[indexC] != 0) return false;
        }
        return true;        
    }
	
	bool isAnagramB(string s, string t) 
	{
        if(s.size() != t.size()) {
            return false;
        }

        // 假设字符串只包含小写字母
		int alphabet[26] = {0};

        // 统计字符串s中小写字母出现的次数
        for(int indexStr = 0; indexStr < s.size(); ++indexStr){
            alphabet[alphabet[indexStr]-'a']++;
        }

        // 长度固定，所有字母出现的次数必须都相同
        for(int indexStr = 0; indexStr < t.size(); ++indexStr){
            if(--alphabet[alphabet[indexStr] - 'a'] < 0)
                return false;
        }

        return true;
	}
};