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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
         
    ListNode* p1 = l1;
	ListNode* p2 = l2;

	ListNode* L  = (ListNode*)malloc(sizeof(ListNode));
	ListNode* r = L;
	while (p1 != NULL && p2 != NULL)
	{
		if (p1->val <= p2->val)
		{
			r->next = p1;
			p1 = p1->next;
		}
		else
		{
			r->next = p2;
			p2 = p2->next;
		}

		r = r->next; 
	}

	if (p1 != NULL)
	{
		r->next = p1;
	}

	if (p2 != NULL)
	{
		r->next = p2;
	}

	ListNode* p = L->next;
	free(L);
	return p;
        }
};