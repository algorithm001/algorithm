bool isAnagram(string s, string t) {
        if(s.size() != t.size())    return false;
        vector<int> just(26, 0);
        for(int i=0; i<s.size(); i++){
            just[s[i]-'a']++;
            just[t[i]-'a']--;
        }
        for(int p: just)
            if(p!=0)
                return false;
        return true;
    }
