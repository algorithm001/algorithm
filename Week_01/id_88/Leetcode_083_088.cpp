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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* pre = head;
		ListNode* cur = head;
		int val = 0;

		if (NULL == head)
		{
			return NULL;
		}

		val = cur->val;

		while (cur->next != NULL)
		{
			cur = cur->next;
			if (val == cur->val)
			{
				pre->next = cur->next;
				delete(cur);
				cur = pre;
			}
			else
			{
				val = cur->val;
                pre = cur;
			}
		}

		return head;
    }
};