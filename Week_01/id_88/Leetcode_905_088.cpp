/* 
*  解题思路：分别用head tail指向首尾两个元素，从首尾两个元素开始，
*   （1）如果头元素为奇数，尾元素为偶数，则两数交换，head指向下一个元素，tail指向上一个元素
*   （2）如果头元素为奇数，尾元素为奇数，则head不动，tail指向上一个元素
*   （3）如果头元素为偶数，尾元素为偶数，则head指向下一个元素，tail不动
*   （4）如果头元素为偶数，尾元素为奇数，则head指向下一个元素，tail指向上一个元素
*  直到head>=tail
*
*/

class Solution {
public:
	vector<int> sortArrayByParity(vector<int>& A) {
		int head = 0;
		int tail = A.size() - 1;
		int tmp = 0;

		while (head < tail)
		{
			if (A.at(head) % 2 != 0)
			{
				if (A.at(tail) % 2 == 0)
				{
					tmp = A.at(head);
					A.at(head) = A.at(tail);
					A.at(tail) = tmp;
					head++;
					tail--;
				}
				else
				{
					tail--;
				}
			}
			else
			{
				if (A.at(tail) % 2 == 0)
				{
					head++;
				}
				else
				{
					head++;
					tail--;
				}
			}
		}
		return A;
	}
};