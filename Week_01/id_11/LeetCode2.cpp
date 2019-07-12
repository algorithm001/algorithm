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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        
        int s1 = len(l1);
        int s2 = len(l2);
        
        if(s1 < s2)
        {
            ListNode* temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        int add = 0;
        ListNode* res = l1;
        ListNode* prev = l1;
        while(l2 != NULL)
        {
            int sum = l1->val+ l2->val + add;
            add = sum / 10;
            l1->val = sum %10;
            prev = l1;
            l1 = l1->next;
            l2 = l2->next;
        }
        
        
        while(l1!= NULL)
        {
            int sum = l1->val + add;
            add = sum / 10;
            l1->val =  sum %10;
            prev = l1 ;
            l1 = l1->next;
        }

        if(add != 0)
        {
           prev->next = new ListNode(add);
        }
        
        return res;
        
    }
    
    
    int len(ListNode* l)
    {
        int size = 0;
        ListNode* p = l;
        while(p != NULL)
        {
            p = p->next;
            size++;
        }
        return size;
        
    }
    
    
};
