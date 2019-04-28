class Solution {
public:
    bool isMatchStack(stack<char> &strStack, char c)
    {
        if(strStack.empty()) return false;
        
        switch(c)
        {
            case ')':
            {
               if('(' ==  strStack.top())
               {
                   strStack.pop();
                   return true;
               } 
                break;
            }
            case '}':
            {
               if('{' ==  strStack.top())
               {
                   strStack.pop();
                   return true;
               }
                break;
            }
            case ']':
            {
               if('[' ==  strStack.top())
               {
                   strStack.pop();
                   return true;
               }
                break;
            }
        }
        return false;
    }
    
    bool isValid(string s) 
    {
        if(s.empty()) return true;
        
        stack<char> strStack;
        for(int i = 0; i < s.size(); ++i)
        {
            if( (s[i] == '(') || (s[i] == '[') || (s[i] == '{') )
            {
                strStack.push(s[i]);
            }
            else if( !isMatchStack(strStack,s[i]) )
            {
                return false;
            }
        }
        if(strStack.empty()) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
};