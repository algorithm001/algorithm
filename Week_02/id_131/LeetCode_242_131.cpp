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
};