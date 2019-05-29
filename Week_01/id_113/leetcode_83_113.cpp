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
        if (head == NULL) return NULL;
        
        ListNode* p = head;
        while(p != NULL) {
            ListNode* q = p->next;
            while(q != NULL && p->val == q->val) {
                q = q->next;
            }
            
            p->next = q;
            p = p->next;
        }
        
        return head;
    }
};
