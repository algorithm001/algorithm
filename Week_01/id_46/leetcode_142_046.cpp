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
    ListNode *detectCycle(ListNode *head) {
        set<ListNode*> res;
        while(head){
            auto it = res.find(head);
            if(it!=res.end())
                return head;
            else{
                res.insert(head);
                head = head->next;   
            }
        }
        return NULL;
    }
};
