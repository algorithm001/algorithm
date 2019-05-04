/* 
*  解题思路：建立一个栈，遍历输入的符号串，当遇到'(' '{' '['符号时则进栈，
*  若出现')' '}' ']'时，则从栈中取出一个符号，如果为该右括号的左括号，则表示成功。
*
*/

class Solution {
private:
	vector<char> opStack;
public:
	bool isValid(string s) {
		string::iterator itr = s.begin();
		for (; itr != s.end(); itr++)
		{
			char temp = *itr;
			if (temp == '(' || temp == '{' || temp == '[')
			{
				opStack.push_back(temp);
			}
			else if (temp == ')' || temp == '}' || temp == ']')
			{
				if (!bMatchWithOpStack(temp))
					return false;
				else
					opStack.pop_back();
			}
		}
        //如果遍历完字符串后，opStack仍然有未匹配的符号，则表示错误。
        if(!opStack.empty()) return false;
        
		return true;
	}

	bool bMatchWithOpStack(char op)
	{
		bool ret = false;
        //如果opStack为空，表示没有符号与op匹配，返回错误
        if(opStack.empty()) return ret;

		char temp = opStack.back();

		switch (op)
		{
		case ')':
			if (temp == '(') ret = true;
			break;

		case '}':
			if (temp == '{') ret = true;
			break;

		case ']':
			if (temp == '[') ret = true;
			break;
		default:
			break;
		}

		return ret;
	}
};