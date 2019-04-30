/*
解题思路：
（1）首先判断两个字符串的长度是否一致，如果不一致，则直接返回false。
（2）使用哈希表记录s串中每个字母出现的次数，key为字符，value为次数。
（3）使用t串中没个字符作为key值查找哈希表，如果查找不到，直接返回false，如果查找到，则次数减1，如果次数少于0，则返回false。
*/

class Solution {
public:
	bool isAnagram(string s, string t) {
		unordered_map<char, int> charMap;
		string::iterator itr;

		if (s.length() != t.length())
		{
			return false;
		}

		for (itr = s.begin(); itr != s.end(); itr++)
		{
			if (charMap.find(*itr) == charMap.end())
			{
				charMap[*itr] = 1;
			}
			else
			{
				charMap[*itr]++;
			}
		}

		for (itr = t.begin(); itr != t.end(); itr++)
		{
			if (charMap.find(*itr) == charMap.end())
			{
				return false;
			}
			else {
				charMap[*itr]--;
				if (charMap[*itr] < 0 )
				{
					return false;
				}
			}
		}

		return true;
	}
};