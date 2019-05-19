/**[链表][简单]
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
示例 1:
输入: 1->1->2
输出: 1->2
示例 2:
输入: 1->1->2->3->3
输出: 1->2->3
*/

/*
个人感悟：
指针的使用要好好琢磨
*/

/*
思路1：由于输入的列表已排序，因此我们可以通过将结点的值与它之后的结点进行比较来确定它是否为重复结点。
如果它是重复的，我们更改当前结点的 next 指针，以便它跳过下一个结点并直接指向下一个结点之后的结点。
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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* current = head;
        while(current && current->next){
            if(current->val == current->next->val){
                current->next = current->next->next;
            }else{
                current = current->next;
            }
        }
        return head;
    }
};