#include "stdafx.h"
#include <string>
#include <stack>
using namespace std;


//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
//Author : �λ�
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

// ����˼·�������Կ�����ջ�����������'(','[','{'������ջ���ɣ�����']'��')'��'}'ʱ�����ջ��Ԫ���Ƿ������ţ�����Ǿͳ�ջ����������ջ
// ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)

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