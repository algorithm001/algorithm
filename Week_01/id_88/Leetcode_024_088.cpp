/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
	ListNode* swapPairs(ListNode* head) {
		ListNode* pFirst = head;
		ListNode* pSecond = NULL;
		ListNode* pNewListCur = NULL;

		if (head == NULL) return NULL;

		while (pFirst != NULL && pFirst->next != NULL)
		{
			pSecond = pFirst->next;

			pFirst->next = pSecond->next;
			pSecond->next = pFirst;

			if (head == pFirst)
			{
				pNewListCur = head = pSecond;
			}
			else
			{
				pNewListCur->next = pSecond;
			}

			pFirst = pFirst->next;

			pNewListCur = pSecond->next;
		}

		return head;
	}
};