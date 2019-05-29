/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *detectCycle(struct ListNode *head) {
    if (head == NULL || head->next == NULL) return NULL;
    struct ListNode *fast = head, *slow = head;
    
    // 1st loop, check the existence of cycle 
    while (fast != NULL && fast->next != NULL) {
        fast = fast->next->next;
        slow = slow->next;
        if (fast == slow)   break;
    }

    if (fast == NULL || fast->next == NULL) return NULL;
    
    // 2st loop, check the place of node which tail node connects to 
    struct ListNode *curr = head;
    while (curr != slow) {
        curr = curr->next;
        slow = slow->next;
    }
    return curr;
}