#include "stdafx.h"
#include <string>
#include <stack>
using namespace std;


//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
//Author : 何欢
//Date   : 2019-04-15

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

	An input string is valid if:

Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
	Note that an empty string is also considered valid.

	Example 1:

Input: "()"
Output: true
		Example 2:

Input: "()[]{}"
Output: true
		Example 3:

Input: "(]"
Output: false
		Example 4:

Input: "([)]"
Output: false
		Example 5:

Input: "{[]}"
Output: true
*/

// 解题思路：很明显可以用栈来解决，对于'(','[','{'尽管入栈即可，对于']'，')'，'}'时，检查栈顶元素是否左括号，如果是就出栈，不是则入栈
// 时间复杂度O(n),空间复杂度O(n)

class Solution {
public:
	bool isValid(string s) {
		
		std::stack<char> ret;
		int len = s.length();
		for (int i = 0; i < len; i++)
		{
			char sz = s[i];
			switch (sz)
			{
			case '(':
				ret.push(sz);
				break;
			case '[':
				ret.push(sz);
				break;
			case '{':
				ret.push(sz);
				break;
			case ')':
				{
					if (ret.top() == '(')
						ret.pop();
					else
						ret.push(sz);
				}
				break;
			case ']':
				{
					if (ret.top() == '[')
						ret.pop();
					else
						ret.push(sz);
				}
				break;
			case '}':
				{
					if (ret.top() == '{')
						ret.pop();
					else
						ret.push(sz);
				}
				break;
			default:
				break;
			}
		}
		return ret.empty();
	}
};


int _tmain(int argc, _TCHAR* argv[]){

	Solution sln;
	sln.isValid("((");
	return 0;
}