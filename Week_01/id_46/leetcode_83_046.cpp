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
        if(!head || !head->next) return head;
        ListNode* pre = head;
        ListNode* cur = head->next;
        while(cur){
            if(cur->val==pre->val){
                ListNode* tmp=cur;
                pre->next=cur->next;
                cur=cur->next;
                delete tmp;
            }
            else{
                pre=cur;
                cur=cur->next;
            }
        }
         return head;
    }
};
