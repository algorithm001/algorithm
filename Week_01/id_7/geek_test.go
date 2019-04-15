package geekcode

import (
	"fmt"
	"testing"
)

func NewList(nums []int) {

}

func TestMergeList(t *testing.T) {
	l1 := InitList([]int{1, 2, 3, 4, 5, 8, 10})
	fmt.Println("print l1")
	PrintList(l1)
	l2 := InitList([]int{1, 2, 3, 4, 5, 20, 35, 50, 98})
	fmt.Println("print l2")
	PrintList(l2)

	//l3 := mergeTwoLists(l1, l2)
	l3 := mergeTwoLists2(l1, l2)
	PrintList(l3)

}

func TestTwoSum(t *testing.T) {
	nums := []int{3, 3}
	t.Log(twoSum(nums, 6))
}

func TestSingleNumber(t *testing.T) {
	nums := []int{3, 3, 1}
	t.Log(singleNumber(nums))
}
