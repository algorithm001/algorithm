/**[链表][简单]
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
*/

/*
个人感悟：
指针的使用要好好琢磨
疑惑：指针当初创建出来时为了解决什么问题，
没有指针的语言是如何实现链表。
*/

/*
思路1：将一个链表逐个插入另一个链表中
*/

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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *p1 = l1, *p2 = l2;
        static ListNode dummy(0);
        dummy.next = p1; //将傀儡节点接入p1指针所指向的链表
        ListNode *prev = &dummy; //添加前驱指针
        //将p2指针所指向的链表元素，逐个插入p1
        //因为有傀儡节点，不用考虑头节点改变问题
        while(p1 && p2){
            if(p1->val < p2->val){
                prev = p1;
                p1 = p1->next;
            }else{
                prev->next = p2;
                p2 = p2->next;
                prev = prev->next;
                prev->next = p1;
            }
        }
        
        if(p2){//将现在p2指针所指向的链表的剩余节点加入
            prev->next = p2;
        }
        
        return dummy.next;
    }
};