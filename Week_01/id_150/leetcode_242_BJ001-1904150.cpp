class Solution {
public:
    bool isAnagram(string s, string t) {
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        return s == t ? true: false;
    }
};

class Solution {
public:
    bool isAnagram(string s, string t) {
        int lens = s.size();
        int lent = t.size();
        if(lens != lent) return false;
        
        vector<int> vc(26,0);
        for(int i = 0; i < lens; i++) {
            vc[s[i]-'a']++;
            vc[t[i]-'a']--;
        }
        
        for(int i = 0; i < 26; i++) {
            if(vc[i]) return false;
        }
        return true;
    }
};