class Solution {
public:
    bool isValid(string s) {
        map<char,char> m;
        m[')'] = '(';
        m[']'] = '[';
        m['}'] = '{';
        stack<char> my_stack;
        for(int i; i < s.size(); ++i) {
            if(!m.count(s[i])) my_stack.push(s[i]);
            if(m.count(s[i]) && my_stack.empty()) return false;
            if(m.count(s[i]) && my_stack.top() != m[s[i]]) return false;
            if(m.count(s[i]) && my_stack.top() == m[s[i]]) my_stack.pop();
        }
        return my_stack.empty();
        
    }
};