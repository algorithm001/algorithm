class Solution {
public:
    bool isValid(string s) {
        if (s.size() == 0) {
            return true;
        }
        
        std::unordered_map<char,char> hash = {
            {'(', ')'},
            {'[', ']'},
            {'{', '}'},
        };
        
        std::unordered_map<char,char>::iterator iter;
        
        std::stack<char> test;
        
        for (string::size_type i=0;i<s.size();i++) {
            if (!test.empty()) {
                iter = hash.find(test.top());
                if (s[i] == iter->second) {
                   test.pop(); 
                } else if (hash.find(s[i]) != hash.end()) {
                    test.push(s[i]);
                } else {
                    return false;
                }
            } else {
                if (hash.find(s[i]) != hash.end()) {
                    test.push(s[i]);
                } else {
                    return false;
                }
            }
        }
        
        return test.empty();
    }
};
