package geekcode

import (
	_ "log"
)

var (
	nums []int
)

// nums 有序存放结果  ， 从大到小排列
// 从第二个非nil 元素开始
// 从 头开始遍历 找到位置插入
// c < nums[0] 忽略
// 当前元素 c nums[i] nums[i+1]

func PutToNums(i int) {
	l := len(nums)
	switch l {
	case 0:
		nums = append(nums, i)
	case 1:
		if nums[0] != i {
			nums = append(nums, i)
			if nums[0] < nums[1] {
				nums[1], nums[0] = nums[0], nums[1]
			}
		}
	default:
		if i < nums[0] {
			if i < nums[1] {
				nums[0], nums[1] = nums[1], i
			} else {
				nums[0] = i
			}
		}
	}
}

func loopTree(root *TreeNode) {
	if root == nil {
		return
	} else {
		PutToNums(root.Val)
	}
	loopTree(root.Left)
	loopTree(root.Right)
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findSecondMinimumValue(root *TreeNode) int {
	loopTree(root)
	l := len(nums)
	if l < 2 {
		return -1
	} else {
		return nums[0]
	}
}
