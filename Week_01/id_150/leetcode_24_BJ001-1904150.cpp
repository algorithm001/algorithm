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
        if(!head || !head->next)
            return head;
        ListNode* pphead = new ListNode(-1);
        pphead->next = head;
        
        ListNode* p = pphead;

        while(p->next && p->next->next) {
            ListNode* father = p->next;
            ListNode* children = p->next->next;
            ListNode* tmp = children->next;
            
            p->next = children;
            children->next = father;
            father->next = tmp;
            p = father;
        }
        return pphead->next;
    }
};