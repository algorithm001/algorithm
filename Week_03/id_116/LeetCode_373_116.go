package main

type KSmallestPairs struct {
	queue [][]int
	size  int
	k     int
}

func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {
	ksp := &KSmallestPairs{}
	ksp.queue = make([][]int, k)
	ksp.k = k
	for i := 0; i < len(nums1); i++ {
		for j := 0; j < len(nums2); j++ {
			arr := []int{nums1[i], nums2[j]}
			ksp.Add(arr)
		}
	}
	if len(ksp.queue[0]) == 0 {
		return nil
	}
	if ksp.k > ksp.size {
		return ksp.queue[0:ksp.size]
	}
	return ksp.queue[0:ksp.k]
}

func (this *KSmallestPairs) Add(val []int) []int {
	if this.size < this.k {
		this.add(val)
	} else if getSum(this.peek()) > getSum(val) {
		this.poll()
		this.add(val)
	}
	return this.peek()
}

func (this *KSmallestPairs) poll() []int {
	if this.size == 0 {
		return nil
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

func (this *KSmallestPairs) peek() []int {
	if this.size == 0 {
		return nil
	} else {
		return this.queue[0]
	}
}

func (this *KSmallestPairs) add(val []int) bool {
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

func (this *KSmallestPairs) grow(minCapacity int) {
	oldCapacity := len(this.queue)
	var newCapacity int
	if oldCapacity < 64 {
		newCapacity = oldCapacity + oldCapacity + 2
	} else {
		newCapacity = oldCapacity + (oldCapacity >> 1)
	}
	newQueue := make([][]int, newCapacity)
	copy(newQueue, this.queue)
	this.queue = newQueue
}

func (this *KSmallestPairs) siftUp(k int, val []int) {
	for k > 0 {
		parent := (k - 1) >> 1
		valP := this.queue[parent]
		if getSum(val) <= getSum(valP) {
			break
		}
		this.queue[k] = valP
		k = parent
	}
	this.queue[k] = val
}

func (this *KSmallestPairs) siftDown(k int, val []int) {
	half := this.size >> 1
	for k < half {
		child := (k << 1) + 1
		c := this.queue[child]
		right := child + 1
		if right < this.size && getSum(c) < getSum(this.queue[right]) {
			child = right
			c = this.queue[child]
		}
		if getSum(val) >= getSum(c) {
			break
		}
		this.queue[k] = c
		k = child
	}
	this.queue[k] = val
}

func getSum(arr []int) int {
	return arr[0] + arr[1]
}
