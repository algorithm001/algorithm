class Solution {
public:
    bool isValid(string s) {
        int lens = s.size();
        if(!lens) return true;
        
        stack<char> st;
        
        for(int i = 0; i < lens; i++) {
            if(s[i] == '(' || s[i] == '[' || s[i] =='{')
                st.push(s[i]);
            else{
                if(st.empty()) return false;
                char tp = st.top();
                if(s[i] == ')' && tp == '(') 
                    st.pop();
                else if(tp == '[' && s[i] == ']')
                    st.pop();
                else if(tp == '{' && s[i] == '}')
                    st.pop();
                else
                    return false;
            }
        } 
        bool res = st.empty() == true ? true : false;
        return res;
    }
};