package wee1

import "fmt"

/*
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
*/

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1==nil {
		return l2
	}else if l2==nil{
		return l1
	}
	c1,p1:=l1,l1
	c2,p2:=l2,l2

	for c1!=nil && c2!=nil {
		if c1.Val>c2.Val {
			p2=c2
			c2=c2.Next

			if p1==c1{
				p2.Next=p1
				p1=p2
				l1=p2
			}else{
				p2.Next=c1
				p1.Next=p2
				p1=p2

			}
		}else{
			p1=c1
			c1=c1.Next
		}

	}
	if c1==nil{
		p1.Next=c2
	}

	return l1
}
