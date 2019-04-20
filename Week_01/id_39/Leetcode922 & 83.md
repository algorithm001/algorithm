# 学习笔记

题目一(Leetcode 922):

给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。



示例：

输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。


代码:
/**
 * 
 */
/**
 * @author Paula
 *
 */
package com.paula.algorithmsAndDataStructure.array.week01.homework_leetCoode_922;


class Solution_LeetCode922 {
	public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
    	int i=0; //偶数下标
    	int j=i+1; //奇数下标
    	Boolean evenIndexOddValue = false;
    	Boolean oddIndexEvenValue = false;

        while (i < len-1 && j < len) {
        	evenIndexOddValue = isOdd(A[i]);
            oddIndexEvenValue= isEven(A[j]);

        	if(!evenIndexOddValue) i +=2;
        	if(!oddIndexEvenValue) j +=2;
        	if(evenIndexOddValue && oddIndexEvenValue) {
        		int tempVal = A[i];
        		A[i] = A[j];
        		A[j] = tempVal;

        		i += 2;
        		j += 2;

        	}
        }


    	return A;
    }

    public static boolean isEven(int value) {

    	return value%2 == 0 ? true : false;
    }

    public static boolean isOdd(int value) {

    	return value%2 == 1 ? true : false;
    }
}

题目二(Leetcode 83:
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2

示例 2:

输入: 1->1->2->3->3
输出: 1->2->3

代码:
[方法一] 空间换时间
/**
 * Definition for singly-linked list.
 * public class ListNode_LeetCode83 {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {


	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;

		ListNode p = head;
		ListNode q = null;
        while(p.next != null) {
        	if(p.val == p.next.val) {
        		if(q == null || (q != null && q.val != p.val)) {
        			q = p;
        		}
        	}else {
        		if(q != null && q.val == p.val) {
        			q.next = p.next;
        		}
        	}
        	p = p.next;
        }

        if(q != null && p.val == q.val && p.next == null) {
        	q.next = null;
        } 
		return head;
    }
}



[方法二]时间换空间
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_LeetCode83 {


	/**
	 * 注意:
	 * 1) 单向链表删除结点时, 需要找出前驱结点, 时间复杂度为O(n)
	 * 2) 边界条件:
	 *    a. p为null 或者 链表为null
	 *    b. p为头结点
	 *    c. p不在链表中
	 */
	public void delNode(ListNode head, ListNode p) {
		if (head == null || p == null) return;

		if(head == p) {
			head = head.next;
			return;
		}
		ListNode q = head;
		while(q.next != p && q != null) {
			q = q.next;
		}

		//已经遍历完链表
		if (q == null) return;

		//q.next = p.next;
		q.next = q.next.next;


	}



	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;

		ListNode q = head;
        while(q.next != null) {
        	if(q.val == q.next.val) {
        		delNode(head, q.next);
        	}else {
        		q = q.next;
        	}     	
        }
		return head;
    }


}
