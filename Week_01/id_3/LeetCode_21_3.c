/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#include<stdio.h>
#include<stdlib.h>

struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *head = NULL;
    struct ListNode *tail = NULL;
    struct ListNode *p = l1;
    struct ListNode *q = l2;
    struct ListNode *tmp;

    while(NULL != p && NULL != q)
    {
        //find
        if(p->val <= q->val)
        {
            tmp = p;
            p = p->next;
        }
        else
        {
            tmp = q;
            q = q->next;
        }

        //insert
        if(NULL == head)
        {
            head = tmp;
            tail = tmp;
        }
        else
        {
            tail->next = tmp;
            tail = tmp;
        }
    }

    //remain
    tmp = NULL != p ? p : q;
    if(NULL == head)
    {
        head = tmp;
    }
    else
    {
        tail->next = tmp;
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

int main()
{
    struct ListNode *l1 = NULL;
    struct ListNode *l2 = NULL;
    struct ListNode *l3 = NULL;
    struct ListNode *p;
    int a[1] = {0};
    int loop;

    for(loop = 0; loop < 0; loop++)
    {
        p = (struct ListNode*)malloc(sizeof(struct ListNode));
        p->val = a[loop];
        p->next = NULL == l1 ? NULL : l1;
        l1 = p;
    }

    for(loop = 0; loop < 1; loop++)
    {
        p = (struct ListNode*)malloc(sizeof(struct ListNode));
        p->val = a[loop];
        p->next = NULL == l2 ? NULL : l2;
        l2 = p;
    }

    printLinkList(l1);
    printLinkList(l2);

    l3 = mergeTwoLists(l1, l2);
    printLinkList(l3);

    return 0;
}