package main

import (
	"fmt"
	"time"
)

var count = 0
func main() {
	//arr := make([]int,10)
	//test(arr)

	i,arr :=1,[]int{1,2,3}

	i ,arr = 0, arr[i:]
	fmt.Println(arr)
}

func test(arr []int ) []int {
	if count == 20 {
		return arr
	}else{
		count++
		caps:= cap(arr)
		for i:= 0;i< 2 * caps;i++{
			arr = append(arr, i)
		}
		println(arr, cap(arr))
		time.Sleep(1000)
		arr = test(arr)
	}
	return arr
}