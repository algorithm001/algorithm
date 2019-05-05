/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteDuplicates(struct ListNode* head) {
    if (head == NULL ||head->next == NULL) {
        return head;
    }
    struct ListNode* p = head;
    int value = p->val;
    while(p->next != NULL) {
        if(p->next->val == value) {
            deleteNode(p);
        }
        //边界条件
        if (p->next != NULL) {
            if (p->next->val > value) {
            p = p->next;
            value = p->val;
          }
        }
    }
    return head;
}
//删除节点p的后继节点
void deleteNode(struct ListNode* p) {
    struct ListNode* q;
    if (p->next != NULL) {
        q = p->next;
        p->next = q->next;  
        q = NULL;
    }
}