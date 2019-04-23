/**
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
*/

package solution

/*
1.golang中使用的小顶堆,heap.pop()删除都是最顶上的元素
2.如何判断是最小的元素呢? 使用Less对挑选数据,最满足条件的那一个元素就应该放在堆顶
3.调用堆的操作结构体需要实现的方法,必须要有Len, Less, Swap, Push, Pop
func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}
func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}
4.如果单维不能够解决问题, 设想使用结构体转化为多维的思路; 当时使用结构体来存储单词和次数,就是一种好思路.
5.heap.Init(&h)之后可以使用heap.Pop(h), heap.push(h, &Fre{})
*/

import (
	"container/heap"
)

type Fre struct {
	Word  string
	Times int
}

// 空间复杂度
type FreHeap []Fre

func (h FreHeap) Len() int {
	return len(h)
}

// 次数不同,直接删除次数小的
// 次数相同,直接删除字母表排序在后的
// 各元素之间比较,将最小的元素放在堆顶, pop的时候就会删除
func (h FreHeap) Less(i, j int) bool {
	if h[i].Times == h[j].Times {
		return h[i].Word > h[j].Word
	}
	return h[i].Times < h[j].Times
}
func (h FreHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *FreHeap) Push(x interface{}) {
	*h = append(*h, x.(Fre))
}

// 删除最后一个
func (h *FreHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func topKFrequent(words []string, k int) []string {
	m := make(map[string]int)
	for i := 0; i < len(words); i++ {
		m[words[i]]++
	}

	h := &FreHeap{}
	heap.Init(h)
	for key, v := range m {
		heap.Push(h, Fre{key, v})
		if h.Len() > k {
			// 删除堆顶元素
			heap.Pop(h)
		}
	}
	i := k - 1
	ret := make([]string, k)
	for h.Len() != 0 {
		v := heap.Pop(h).(Fre)
		ret[i] = v.Word
		i--
	}
	return ret
}
