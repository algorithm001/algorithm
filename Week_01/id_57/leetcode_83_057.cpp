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
        ListNode* cur = head;
        while (cur != NULL && cur->next != NULL)
        {
            if(cur->val == cur->next->val)
            {
                cur->next = cur->next->next;
                continue;               
            } 
             cur = cur->next;
        }
        return head;
    } 
};


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 * 无序链表处理
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* res = head;
        ListNode* pre = NULL;
        ListNode* cur = head;
        ListNode* next = NULL;
        int i = 0;
        unordered_map<int,int> M;
        if (cur == NULL || cur->next == NULL)
            return res;
        next = cur->next;
        M[cur->val] = i++;
        while(next != NULL)
        {
            if (M.find(next->val) == M.end())
            {
                M[next->val] = i++;
                pre = cur;
                cur = next;
                next = next->next;
                printf("i %d\n",i);
            }
            else
            {
                if(pre)
                {
                    if (res ==cur)
                        res = next;
                    pre->next = next;                    
                    cur = next;
                    next = next->next;
                }
                else
                {
                    res = next;
                    pre = cur;
                    cur = next;
                    next = next->next;
                    printf("res: %d\n",res->val);
                }
            }
        }
        return res;
        
    }
};