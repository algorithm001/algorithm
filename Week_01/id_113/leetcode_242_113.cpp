class Solution {
public:
    bool isAnagram(string s, string t) {
        char h[128];
        for(int i=0;i<128;i++) {
            h[i] = 0;
        }
        for(int i=0;i<s.length();i++) {
            h[s[i]] += 1;
        }
        for(int i=0;i<t.length();i++) {
            h[t[i]] -= 1;
        }
        bool result = true;
        for(int i=0;i<128;i++) {
            if (h[i] != 0) {
                result = false;
            }
        }
        return result;
    }
};
