package main

import (
	"container/heap"
	"fmt"
)

type minHeap [][]int

func (m minHeap) Len() int {
	return len(m)
}

func (m minHeap) Less(i, j int) bool {
	v1 := m[i][0] + m[i][1]
	v2 := m[j][0] + m[j][1]
	return v1 > v2
}

func (m minHeap) Swap(i, j int) {
	m[i],m[j] = m[j], m[i]
}

func (m *minHeap) Push(x interface{}) {
	*m = append(*m, x.([]int))
}

func (m *minHeap) Pop() interface{} {
	old := *m
	n := len(old)
	x := old[n-1]
	*m = old[0 : n-1]
	return x
}

func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {
	v := &minHeap{}
	heap.Init(v)
	for _,v1 := range nums1 {
		for _,v2 := range nums2 {
			if v.Len() < k {// 这里不能都添加完在移除，因为在pop哪里，移除方法并不是移除最大的，而是最后一个，如果保证堆内的数量，则可以保证，移除的一定是最大的。
				heap.Push(v,[]int{v1,v2})
			}else {
				heap.Push(v,[]int{v1,v2})
				heap.Pop(v)
			}
		}
	}
	fmt.Println(v)
	for v.Len() > k {
		v.Pop()
	}
	fmt.Println(v)
	return *v
}

func main() {
	num1 := []int{1,2,4,5,6}
	num2 := []int{3,5,7,9}
	kSmallestPairs(num1,num2,3)
}

