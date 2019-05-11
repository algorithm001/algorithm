//
// Created by 贾凯超 on 2019/4/18.
//
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

//#142 给定一个链表，返回链表开始入环的第一个结点。 如果链表无环，则返回 null。
//思考：使用hashMap存放走过的记录，但会增加额外空间
//进阶：在不破坏原链表也不使用额外空间的情况下，使用快慢指针方案。但是由于可能不是一个完整的环
//会导致时间效率降低很多
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        map<ListNode*, int> temp;
        ListNode *current = head;
        while (current) {
            //如果存在，说明曾经走过，第一次出现的即是第一个节点
            if (temp[current]) {
                return current;
            }
            temp[current] = 1;
            current = current->next ? current->next : NULL;
        }
        return NULL;
    }
};
