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
        if(!head || !head->next)
            return head;
        ListNode* pre = head;
        ListNode* p = head->next;
        
        while(p != NULL) {
            if(pre->val == p->val) {
                pre->next = p->next;
            } else {
                pre = p;
            }
            p = p->next;
        }
        return head;
    }
};