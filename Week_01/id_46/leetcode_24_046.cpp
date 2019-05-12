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
        if(!head || !head->next) return head;
        ListNode* pre=new ListNode(0);
        pre->next=head;
        ListNode*cur=pre;
        while(cur->next && cur->next->next){
            ListNode* tmp1 = cur->next;
            ListNode* tmp2 = tmp1->next;
            ListNode* tmp3 = tmp2->next;
            tmp2->next=tmp1;
            tmp1->next = tmp3;
            cur->next = tmp2;
            cur=tmp1;
        }
        return pre->next;
    }
};
