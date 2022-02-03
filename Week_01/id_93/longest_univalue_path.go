package main

import (
	"fmt"
	"math"
)

type TreeNode struct{
	Val int
	Left *TreeNode
	Right *TreeNode
}

/*
5
/ \
4   5
/ \   \
1   1   5
*/

var max int
func longestUnivaluePath(root *TreeNode) int {
	getMax2(root, root.Val)
	return max
}

func getMax2(r *TreeNode, val int) int {
	if r == nil {
		return 0
	}
	left := getMax(r.Left, r.Val)
	right := getMax(r.Right, r.Val)
	max = int(math.Max(float64(max),float64(left)+float64(right)))
	if r.Val == val {
		return int(math.Max(float64(left), float64(right)))+1
	}
	return 0
}

func getMax(root *TreeNode, val int) int {
	if root == nil {
		return 0
	}

	left := getMax(root.Left, root.Val)
	right := getMax(root.Right, root.Val)

	max = int(math.Max(float64(max),float64(left)+float64(right)))

	if root.Val != val {
		return 0
	} else {
		return int(math.Max(float64(left), float64(right)))+1
	}
}






func main() {

	Node5 := TreeNode{Val:5,Left:nil,Right:nil}
	Node4 := TreeNode{Val:1,Left:nil,Right:nil}
	Node3 := TreeNode{Val:1,Left:nil,Right:nil}
	Node2 := TreeNode{Val:4,Left:nil,Right:&Node5}
	Node1 := TreeNode{Val:4,Left:&Node3,Right:&Node4}
	Node := TreeNode{Val:5,Left:&Node1,Right:&Node2}
	fmt.Println(longestUnivaluePath(&Node))
}
