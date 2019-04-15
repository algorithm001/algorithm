package main

import "algorithm/Week_01/id_103/List"

func main() {
	v1 := List.ListNode{Val: int(1)}
	v2 := List.ListNode{Val: int(2)}
	v3 := List.ListNode{Val: int(3)}
	v1.Next, v2.Next = &v2, &v3
	res := List.ReverseGroup(&v1)
	println(res)
}
