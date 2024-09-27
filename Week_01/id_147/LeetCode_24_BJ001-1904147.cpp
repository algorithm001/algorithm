#include <iostream>

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *swapPairs(ListNode *head) {
        ListNode *result = head;
        ListNode *firstPre = nullptr;
        ListNode *first = head;
        ListNode *second = nullptr;
        ListNode *secondNext = nullptr;
        if (first != nullptr) {
            second = first->next;
            result = second;
        }
        while (first != nullptr && second != nullptr) {
            secondNext = second->next;
            second->next = first;
            first->next = secondNext;
            if (firstPre != nullptr) {
                firstPre->next = second;
            }
            firstPre = first;
            first = secondNext;
            if (first != nullptr) {
                second = first->next;
            }
        }
        return result;
    }
};