package main

import (
	"fmt"
	"sort"
)

func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	child := 0
	cookie := 0
	for child < len(g) && cookie < len(s) {
		if g[child] <= s[cookie] {
			child++
		}
		cookie++
	}
	return child
}
func main() {
	child := []int{1, 2, 3}
	cookie := []int{1, 1}
	fmt.Println(findContentChildren(child, cookie), "______")
	child = []int{1, 2}
	cookie = []int{1, 2, 3}
	fmt.Println(findContentChildren(child, cookie), "______")
}
