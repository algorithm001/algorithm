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
        ListNode* data = head;
        while(data != NULL && data->next != NULL)
        {
            if(data->val == data->next->val)
            {
                data->next = data->next->next;
            }
            else
            {
                data = data->next;
            }
        }
        return head;
    }
};