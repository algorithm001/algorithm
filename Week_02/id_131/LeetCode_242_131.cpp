/*
* ��Ч����ĸ��λ��
* ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ��һ����ĸ��λ�ʡ�
* ����: s = "anagram", t = "nagaram"  ���: true
* ����: s = "rat", t = "car" ���: false
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

        // �����ַ���ֻ����Сд��ĸ
		int alphabet[26] = {0};

        // ͳ���ַ���s��Сд��ĸ���ֵĴ���
        for(int indexStr = 0; indexStr < s.size(); ++indexStr){
            alphabet[alphabet[indexStr]-'a']++;
        }

        // ���ȹ̶���������ĸ���ֵĴ������붼��ͬ
        for(int indexStr = 0; indexStr < t.size(); ++indexStr){
            if(--alphabet[alphabet[indexStr] - 'a'] < 0)
                return false;
        }

        return true;
	}
};