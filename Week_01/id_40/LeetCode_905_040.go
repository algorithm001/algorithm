package main

import "fmt"

func sortArrayByParity(A []int) []int {
        if A == nil || len(A) == 1 {
                return A
        }
        left := 0
        right := len(A) - 1
        for left < right {
                //左指针对应偶数值，右指针对应奇数值，进行交换
                if (A[left]&1) == 1 && (A[right]&1) == 0 {
                        A[left], A[right] = A[right], A[left]
                } else if (A[left] & 1) == 0 {
                        //左指针对应的是偶数值，符合题意，继续向右移动
                        left++
                } else if (A[right] & 1) == 1 {
                        //右指针对应的是奇数值，符合题意，继续向左移动
                        right--
                }
        }
        return A
}

func main() {
        fmt.Println("vim-go")
        x := []int{1, 2, 3}
        x = []int{1}
        fmt.Println(sortArrayByParity(x))
}
