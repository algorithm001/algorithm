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
        if(!l1) return l2;
        if(!l2) return l1;
        
        ListNode *head = new ListNode(-1);
        ListNode *p = head;
        ListNode *p1 = l1;
        ListNode *p2 = l2;
        
        while(p1 != NULL && p2 != NULL) {
            if(p1->val < p2->val) {
                p->next = p1;
                p1 = p1->next;
                p = p->next;
            } else {
                p->next = p2;
                p2 = p2->next;
                p = p->next;
            }
        }
        if(p1) 
            p->next = p1;
        if(p2)
            p->next = p2;
        return head->next;
    }
};