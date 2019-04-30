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
        if(head == NULL||head->next == NULL)
            return head;
        ListNode *pre = head;
        ListNode *temp = pre->next;
        ListNode *resHead = temp;
        ListNode *link = head;
        while(temp!=NULL){
            pre->next = temp->next;
            temp->next = pre;
            pre = pre->next;
            if(pre == NULL){
                break;
            }
            temp = pre->next;
            if(temp!=NULL){
                link->next = temp;
                link = pre;
            }else{
                link->next = pre;
                break;
            }
            
        }
        return resHead;
    }
};