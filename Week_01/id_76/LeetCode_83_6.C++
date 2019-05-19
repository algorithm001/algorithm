#include "stdafx.h"

//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
//Author : �λ�
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
 
// ����˼·����������һ�����������������Ǵ�С��������������ͬ��С�����ֻᰤ��һ��
// ����curָ�룬���cur��ֵ�Ƿ����cur->next��ֵ��������ھ�ɾ��cur->next�ڵ㣬����ѭ����������ȣ��Ͱ�cur->nextָ�븳ֵ��cur��
// �߽�������head����Ϊ�գ�Ҳ����ֻ��һ���ڵ�
// ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
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