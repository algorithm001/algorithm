package main

/**
设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。

示例:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
说明:
你可以假设 nums 的长度≥ k-1 且k ≥ 1。

抄袭java.util.PriorityQueue实现
 */
type KthLargest struct {
	queue []int
	size  int
	k     int
}

func Constructor(k int, nums []int) KthLargest {
	kl := &KthLargest{}
	kl.queue = make([]int, k)
	kl.k = k
	for _, num := range nums {
		kl.Add(num)
	}
	return *kl
}

func (this *KthLargest) Add(val int) int {
	if this.size < this.k {
		this.add(val)
	} else if this.peek() < val {
		this.poll()
		this.add(val)
	}
	return this.peek()
}

func (this *KthLargest) poll() int {
	if this.size == 0 {
		return 0
	}
	this.size = this.size - 1
	s := this.size
	result := this.queue[0]
	x := this.queue[s]
	this.queue = this.queue[0:s]
	if s != 0 {
		this.siftDown(0, x)
	}
	return result
}

func (this *KthLargest) peek() int {
	if this.size == 0 {
		return 0
	} else {
		return this.queue[0]
	}
}

func (this *KthLargest) add(val int) bool {
	i := this.size
	if i >= len(this.queue) {
		this.grow(i + 1)
	}
	this.size = i + 1
	if i == 0 {
		this.queue[0] = val
	} else {
		this.siftUp(i, val)
	}
	return true
}

func (this *KthLargest) grow(minCapacity int) {
	oldCapacity := len(this.queue)
	var newCapacity int
	if oldCapacity < 64 {
		newCapacity = oldCapacity + oldCapacity + 2
	} else {
		newCapacity = oldCapacity + (oldCapacity >> 1)
	}
	newQueue := make([]int, newCapacity)
	copy(newQueue, this.queue)
	this.queue = newQueue
}

func (this *KthLargest) siftUp(k int, val int) {
	for k > 0 {
		parent := (k - 1) >> 1
		valP := this.queue[parent]
		if val >= valP {
			break
		}
		this.queue[k] = valP
		k = parent
	}
	this.queue[k] = val
}

func (this *KthLargest) siftDown(k int, val int) {
	half := this.size >> 1
	for k < half {
		child := (k << 1) + 1
		c := this.queue[child]
		right := child + 1
		if right < this.size && c > this.queue[right] {
			child = right
			c = this.queue[child]
		}
		if val <= c {
			break
		}
		this.queue[k] = c
		k = child
	}
	this.queue[k] = val
}