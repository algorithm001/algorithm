#include "stdafx.h"

//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
//Author : 何欢
//Date   : 2019-04-15


/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

	Example 1:

Input: 1->1->2
Output: 1->2
		Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
*/

 // Definition for singly-linked list.
  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
// 解题思路，首先这是一个有序链表，例子中是从小到大排序，所以相同大小的数字会挨在一起
// 设置cur指针，检查cur的值是否等于cur->next的值，如果等于就删除cur->next节点，继续循环；如果不等，就把cur->next指针赋值给cur。
// 边界条件：head可能为空；也可能只有一个节点
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
		ListNode *cur = head;
		if (cur == NULL){
			return cur;
		}
		
		if  (cur->next == NULL){
			return cur;
		}

		while (cur != NULL && cur->next != NULL){
			if (cur->val == cur->next->val){
				cur->next = cur->next->next;
			}
			else{
				cur = cur->next;
			}
		}
		return head;
    }
};


int _tmain(int argc, _TCHAR* argv[]){

	Solution sln;
	sln.deleteDuplicates(NULL);
	return 0;
}