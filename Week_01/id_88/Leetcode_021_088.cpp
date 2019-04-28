/* 
*  解题思路：建立两个临时指针指向两个链表头，开始遍历，比较当前指针的val值，取小的元素插入到新的链表中即可。
*  
*
*/


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
private:
    //将节点取出来放到新的链表上，这样处理起来会更容易
	ListNode* newListHead;
	ListNode* pNewListCur;

public:
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
		ListNode* pl1 = l1;
		ListNode* pl2 = l2;
		newListHead = NULL;
		pNewListCur = NULL;

		if (l1 == NULL && l2 == NULL)
		{
			return NULL;
		}

		if (l1 == NULL || l2 == NULL)
		{
			return (l1 == NULL) ? l2 : l1;
		}

		while (pl1 != NULL && pl2 != NULL)
		{
			//把小的取出来插入到新链表中
			if (pl1->val <= pl2->val)
			{
				InsertToNewList(pl1);
				pl1 = pl1->next;
			}
			else
			{
				InsertToNewList(pl2);
				pl2 = pl2->next;
			}
		}

		if (pl1 == NULL)
			pNewListCur->next = pl2;
		else
			pNewListCur->next = pl1;

		return newListHead;

	}

	void InsertToNewList(ListNode* node)
	{
		if (node == NULL) return;

		if (newListHead == NULL)
		{
			pNewListCur = newListHead = node;
		}
		else {
			pNewListCur->next = node;
			pNewListCur = pNewListCur->next;
		}
	}
};