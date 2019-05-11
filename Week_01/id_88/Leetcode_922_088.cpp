/* 
*  解题思路：先遍历一遍数组，
*   （1）把下标index为奇数，val为偶数的元素，按照（index，val）插入到链表head1中
*   （2）把下标index为偶数，val为奇数的元素，按照（index，val）插入到链表head2中
*   按照这两个链表的index和val进行数组值的交换即可
*
*/

class Solution {
    
struct ListNode {
	int index;
	int val;
	ListNode *next;
	ListNode(int i, int v) : index(i),val(v),next(NULL) {}
};
public:
	vector<int> sortArrayByParityII(vector<int>& A) {
		int index = 0;
		ListNode* head1 = NULL;
		ListNode* head2 = NULL;
		ListNode* pCur1 = NULL;
		ListNode* pCur2 = NULL;

		for (int i = 0; i < A.size(); i++)
		{
			if (i % 2 == 0)
			{
				if (A.at(i) % 2 != 0)
				{
					ListNode* newNode = new ListNode(i, A.at(i));
					InsertList(&head1, newNode);
				}
			}
			else
			{
				if (A.at(i) % 2 == 0)
				{
					ListNode* newNode = new ListNode(i, A.at(i));
					InsertList(&head2, newNode);
				}
			}
		}

		pCur1 = head1;
		pCur2 = head2;

		while (pCur1 != NULL && pCur2 != NULL)
		{
			A.at(pCur1->index) = pCur2->val;
			A.at(pCur2->index) = pCur1->val;
			pCur1 = pCur1->next;
			pCur2 = pCur2->next;
		}

		return A;

	}

private:
	void InsertList(ListNode** head, ListNode* node)
	{
		node->next = *head;
		*head = node;
	}
};