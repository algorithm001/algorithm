package geekcode

// 题目地址: https://leetcode-cn.com/problems/merge-two-sorted-lists/
// 合并两个有序链表
//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//示例：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//

import (
	"log"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
* 打印list 类型，方便查看list的结果
 */
func PrintList(list *ListNode) {
	l := list
	for l != nil {
		log.Println(l.Val)
		l = l.Next
	}
}

/**
* 初始化列表
* 使用一个数组初始化
 */
func InitList(nums []int) *ListNode {
	h := new(ListNode)
	l := h
	for _, v := range nums {
		l.Next = &ListNode{Val: v, Next: nil}
		l = l.Next
	}
	return h.Next
}

/**
* Definition for singly-linked list.
* type ListNode struct {
*     Val int
*     Next *ListNode
* }
*
 8 ms, 2.8 MB,
*/
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {

	if l1 == nil {
		return l2
	}

	if l2 == nil {
		return l1
	}

	p0, p1 := l1, l2
	nList := new(ListNode)
	p2 := nList

	for p0 != nil || p1 != nil {
		switch {
		case p0 == nil:
			nList.Next = &ListNode{Val: p1.Val, Next: nil}
			p1 = p1.Next
		case p1 == nil:
			nList.Next = &ListNode{Val: p0.Val, Next: nil}
			p0 = p0.Next
		default:
			if p0.Val <= p1.Val {
				nList.Next = &ListNode{Val: p0.Val, Next: nil}
				p0 = p0.Next
			} else {
				nList.Next = &ListNode{Val: p1.Val, Next: nil}
				p1 = p1.Next
			}
		}

		nList = nList.Next
	}
	return p2.Next
}

/*
* 修改版本，减少内存消耗
* 4ms ,  2.5 MB
 */
func mergeTwoLists2(l1 *ListNode, l2 *ListNode) *ListNode {

	if l1 == nil {
		return l2
	}

	if l2 == nil {
		return l1
	}

	p0, p1 := l1, l2
	nList := new(ListNode)
	p2 := nList

	for p0 != nil || p1 != nil {
		switch {
		case p0 == nil:
			nList.Next = p1
			p1 = p1.Next
		case p1 == nil:
			nList.Next = p0
			p0 = p0.Next
		default:
			if p0.Val <= p1.Val {
				nList.Next = p0
				p0 = p0.Next
			} else {
				nList.Next = p1
				p1 = p1.Next
			}
		}

		nList = nList.Next
	}
	return p2.Next

}
