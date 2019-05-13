/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* swapPairs(struct ListNode* head){
    struct ListNode* prev;
    struct ListNode* p;
    struct ListNode *pnext;

//特殊处理
    if(!head){
        return head;
    }

    p = head;
    pnext = p->next;
    if(!pnext){
        return head;
    }

    p->next = pnext->next;
    pnext->next = p;
    head = pnext;

    prev = p;
    p = p->next;

    while(p){
        pnext = p->next;
        if(!pnext){
            return head;
        }

        prev->next = pnext;
        p->next = pnext->next;
        pnext->next = p;

        prev = p;
        p = p->next;
    }
    
    return head;
}

