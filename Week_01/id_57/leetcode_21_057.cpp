/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// 递归方法
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == NULL) return l2;
        if (l2 == NULL) return l1;
        if (l1->val < l2->val)
        {
            l1->next = mergeTwoLists(l1->next,l2);
            return l1;
        }
        else
        {
            l2->next = mergeTwoLists(l1,l2->next);
            return l2;
        }

    }
};

// 二级指针方法
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *head = NULL;
        ListNode **pCur = &head;
        while(l1 !=NULL && l2 != NULL)
        {
            if(l1->val < l2->val)
            {
                *pCur = l1;
                l1 = l1->next;
            }
            else
            {
                *pCur = l2;
                l2 = l2->next;
            }
            pCur = &(*pCur)->next;
        }
        *pCur = (l1 != NULL ? l1 : l2);
        return head;
        
    }
};