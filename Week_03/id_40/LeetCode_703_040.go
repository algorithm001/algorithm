package main

//维护一个最小堆，堆的元素个数为常量 k，新加入一个元素和堆顶比较，如果比堆顶元素小，丢弃，否则删除堆顶元素，插入新元素。

type KthLargest struct {
	nums []int
	k    int
}

func (kl *KthLargest) Len() int {
	return len(kl.nums)
}

func (kl *KthLargest) Less(i, j int) bool {
	return kl.nums[i] < kl.nums[j]
}

func (kl *KthLargest) Swap(i, j int) {
	kl.nums[i], kl.nums[j] = kl.nums[j], kl.nums[i]
}

func (kl *KthLargest) Push(x interface{}) {
	kl.nums = append(kl.nums, x.(int))
}

func (kl *KthLargest) Pop() interface{} {
	i := len(kl.nums) - 1
	r := kl.nums[i]
	kl.nums = kl.nums[0:i]
	return r
}

func Constructor(k int, nums []int) KthLargest {
	kl := KthLargest{
		nums: make([]int, 0, k),
		k:    k,
	}
	for _, v := range nums {
		if kl.Len() < k {
			heap.Push(&kl, v)
		} else {
			if v > kl.nums[0] {
				heap.Push(&kl, v)
				heap.Remove(&kl, 0)
			}
		}
	}
	return kl
}

func (kl *KthLargest) Add(val int) int {
	if kl.Len() < kl.k {
		heap.Push(kl, val)
	} else {
		if val > kl.nums[0] {
			heap.Push(kl, val)
			heap.Remove(kl, 0)
		}
	}
	return kl.nums[0]
}
