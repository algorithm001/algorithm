package id_123

import (
	"testing"
)

func Test_deleteDuplicates(t *testing.T) {

	head := ListNode{
		Val:  0,
		Next: nil,
	}

	addNodeToTail(&head, 1)
	addNodeToTail(&head, 1)
	addNodeToTail(&head, 2)
	addNodeToTail(&head, 2)
	addNodeToTail(&head, 3)
	addNodeToTail(&head, 4)
	println("原始数据：")
	printAllNode(&head)

	deleteDuplicates(head.Next)
	println("去重后数据：")
	printAllNode(&head)
}

func Benchmark_deleteDuplicates(b *testing.B) {
	for i := 0; i < b.N; i++ {
		head := ListNode{
			Val:  0,
			Next: nil,
		}

		addNodeToTail(&head, 1)
		addNodeToTail(&head, 1)
		addNodeToTail(&head, 2)
		addNodeToTail(&head, 2)
		addNodeToTail(&head, 3)
		addNodeToTail(&head, 4)
		//println("原始数据：")
		//printAllNode(&head)

		deleteDuplicates(head.Next)
		//println("去重后数据：")
		//printAllNode(&head)
	}
}

func Test_addNodeToTail(t *testing.T) {
	head := ListNode{
		Val:  0,
		Next: nil,
	}

	addNodeToTail(&head, 1)
	addNodeToTail(&head, 1)
	addNodeToTail(&head, 2)
	addNodeToTail(&head, 3)
	addNodeToTail(&head, 4)
	printAllNode(&head)
}

func Test_addNodeToHead(t *testing.T) {
	head := ListNode{
		Val:  0,
		Next: nil,
	}

	addNodeToHead(&head, 1)
	addNodeToHead(&head, 2)
	addNodeToHead(&head, 3)
	addNodeToHead(&head, 4)
	printAllNode(&head)
}
