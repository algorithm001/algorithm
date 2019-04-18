/*
* 堆栈实现
* 满足三个条件则有效
* 1. “左” 压栈
* 2. “右” 在栈顶查找匹配的括号, 如果找到弹出栈顶字符，否则返回false
* 3. 最终"栈" 为空, 返回true, "栈" 非空, 返回false
* 注意，对于第一次输入是')','}'或者']'的情况，一定要判断堆栈是否为空，否则会数组越界
*/

class Solution {
    
public:
    bool isValid(string s) {
        vector<char> stack;   
        map<char, char> spouse;
        
        spouse[')'] = '(';
        spouse['}'] = '{';
        spouse[']'] = '[';
        
        for (int i = 0; i< s.size(); ++i) {
            if (s[i] =='(' || s[i] =='[' || s[i] =='{') {
                stack.push_back(s[i]);
            } else {
                if (stack.empty() || spouse[s[i]] != stack[stack.size()-1]) {
                    return false;
                }
                stack.pop_back();
            } 
        }
        
        return stack.empty();
    }
};

