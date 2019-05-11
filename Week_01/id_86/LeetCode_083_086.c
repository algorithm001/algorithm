//simple C

void MethodFor083_1(struct ListNode* head)
{
	if (head == NULL)
	{
		return NULL;
	}
	struct ListNode *p, *q;
	p = head;
	while (p->next)
	{
		q = p->next;
		if (p->val == q->val)
		{
			p->next = q->next;
		}
		else
		{
			p = q;
		}
	}
	return head;
}