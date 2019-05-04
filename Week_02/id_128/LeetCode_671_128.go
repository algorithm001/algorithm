package main

import "fmt"

func main() {
	root := &TreeNode{Val: 5}
	root.Left = &TreeNode{Val: 5}
	root.Right = &TreeNode{Val: 6}
	fmt.Println(findSecondMinimumValue(root)) // 6
}

const MAX = 1 << 31

// 实在写不动了 完全没有时间T_T
func findSecondMinimumValue(root *TreeNode) int {
	if root == nil {
		return -1
	}

	q := []*TreeNode{root}
	min := MAX
	for len(q) > 0 {
		count := len(q)
		for i := 0; i < count; i++ {
			cur := q[0]
			q = q[1:]
			if cur.Val != root.Val && cur.Val < min {
				min = cur.Val
			}
			if cur.Left != nil {
				q = append(q, cur.Left)
			}
			if cur.Right != nil {
				q = append(q, cur.Right)
			}
		}
	}
	if min != MAX && min != root.Val {
		return min
	}

	return -1
}
