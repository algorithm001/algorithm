package main

import "fmt"

/**
 * Definition for a binary tree node.
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func (node *TreeNode) Print() {
	fmt.Print(node.Val, " ")
}

func (node *TreeNode) SetValue(v int) {
	if node == nil {
		fmt.Println("setting value to nil.node ignored.")
		return
	}
	node.Val = v
}

func CreateNode(v int) *TreeNode {
	return &TreeNode{Val: v}
}

func (node *TreeNode) Preorder() {
	if node == nil {
		return
	}
	node.Print()
	node.Left.Preorder()
	node.Right.Preorder()
}

func MyPreorder(node *TreeNode) {
	if node == nil {
		return
	}
	node.Print()
	node.Left.Preorder()
	node.Right.Preorder()
}

func min(l int, r int) int {
	if l > r {
		return r
	}
	return l
}
func firstbigger(root *TreeNode, val int) int {
	if root == nil {
		return -1
	}
	if root.Val > val {
		return root.Val
	}
	left := firstbigger(root.Left, val)
	right := firstbigger(root.Right, val)
	if left < 0 {
		return right
	}
	if right < 0 {
		return left
	}
	return min(left, right)
}
func findSecondMinimumValue(root *TreeNode) int {
	return firstbigger(root, root.Val)
}

func main() {
	root := TreeNode{Val: 2}
	root.Left = CreateNode(2)
	root.Right = CreateNode(2)
	root.Preorder()
	fmt.Println("\n=========")
	fmt.Println(findSecondMinimumValue(&root))
	root = TreeNode{Val: 2}
	root.Left = CreateNode(2)
	root.Right = CreateNode(5)
	root.Right.Left = CreateNode(5)
	root.Right.Right = CreateNode(7)
	root.Preorder()
	fmt.Println("\n=========")
	fmt.Println(findSecondMinimumValue(&root))
}
