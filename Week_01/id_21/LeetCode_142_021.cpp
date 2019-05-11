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
  ListNode *detectCycle(ListNode *head) {
    set<ListNode*> path;
    set<ListNode*>::iterator itr;

    ListNode* p1 = head;
    while(p1 != nullptr) {
      itr = path.find(p1);
      if (itr != path.end()) {
        return *itr;
      }
      path.insert(p1);
      p1 = p1->next;
    }

    return NULL;
  }
};

/**
 * 快慢指针做法
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
  ListNode *detectCycle(ListNode *head) {
    if (head == NULL || head->next == NULL) 
      return NULL;
    
    ListNode* fast = head;
    ListNode* slow = head;
    
    while(fast->next && fast->next->next) {
      slow = slow->next;
      fast = fast->next->next;
      if (slow == fast) {
        fast = head;
        while(slow != fast) {
          slow = slow->next;
          fast = fast->next;
        }
        return fast;
      }
    }
    
    return NULL;
  }
};