class Solution {
public:
    bool isAnagram(string s, string t) {
        char char_s[256] = {};
        char char_t[256] = {};
        for (int i=0; i<=s.length(); i++) {
            char cs = s[i];
            char_s[cs]++;
        }
        
        for (int i=0; i<=t.length(); i++) {
            char ct = t[i];
            char_t[ct]++;
        }
        
        for (int i=0; i< 256; i++) {
            if(char_s[i] != char_t[i]) {
                return false;
            }
        }
        return true;
    }
};