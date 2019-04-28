package id_123

import "fmt"

//Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func addNodeToHead(head *ListNode, val int) *ListNode {
	if head == nil {
		return nil
	}

	node := ListNode{
		Val:  val,
		Next: nil,
	}
	node.Next = head.Next
	head.Next = &node

	return head
}

func addNodeToTail(head *ListNode, val int) *ListNode {
	if head == nil {
		return nil
	}

	p := head
	for p.Next != nil {
		p = p.Next
	}

	node := ListNode{
		Val:  val,
		Next: nil,
	}

	p.Next = &node

	return head
}

func printAllNode(head *ListNode) {
	if head == nil {
		return
	}

	p := head.Next
	valArray := make([]int, 0)
	for p != nil {
		valArray = append(valArray, p.Val)
		p = p.Next
	}

	fmt.Printf("%v\n", valArray)
}

func deleteDuplicates(head *ListNode) *ListNode {
	existValMap := make(map[int]bool, 0)

	p := head
	var prev *ListNode
	for p != nil {
		if _, ok := existValMap[p.Val]; ok {
			prev.Next = p.Next
		} else {
			existValMap[p.Val] = true
			prev = p
		}
		p = p.Next
	}

	return head
}
