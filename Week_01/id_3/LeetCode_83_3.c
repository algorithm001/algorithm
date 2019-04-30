/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#include<stdio.h>
#include<stdlib.h>

struct ListNode{
    int val;
    struct ListNode *next;
};

struct ListNode* deleteDuplicates(struct ListNode* head) {
    struct ListNode* p = head;
    struct ListNode* q;
    struct ListNode* tmp;

    while(NULL != p){
        q = p->next;
        while(NULL != q && p->val == q->val){
            tmp = q;
            q = q->next;
            free(tmp);
        }

        p->next = q;
        p = p->next;
    }

    return head;
}

void printLinkList(struct ListNode* head)
{
    struct ListNode *p = head;

    while(NULL != p)
    {
        printf("%d ", p->val);
        p = p->next;
    }

    printf("\n");
}

int main(int argc, char *argv[])
{
    struct ListNode *head = NULL;
    struct ListNode *p;
    int loop;

    for(loop = 1; loop < argc; loop++)
    {
        p = (struct ListNode*)malloc(sizeof(struct ListNode));
        p->val = strtol(argv[loop], 0, 10);
        p->next = NULL == head ? NULL : head;
        head = p;
    }

    printLinkList(head);

    head = deleteDuplicates(head);
    printLinkList(head);

    return 0;
}
