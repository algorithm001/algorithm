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
        ListNode* mergeNode = new ListNode(0);
        ListNode* newNode = mergeNode;
        while ( l1 !=NULL && l2 != NULL)
        {
            if(l1->val < l2->val)
            {
                newNode->next = l1;
                newNode = newNode->next;
                l1 = l1->next;
            }
            else
            {
                newNode->next = l2;
                newNode = newNode->next;
                l2 = l2->next;
            }
        }
        while(l1 != NULL)
        {
            newNode->next = l1;
            newNode = newNode->next;
            l1 = l1->next;
        }
        while(l2 != NULL)
        {
            newNode->next = l2;
            newNode = newNode->next;
            l2 = l2->next;
        }
        return mergeNode->next;
    }
};