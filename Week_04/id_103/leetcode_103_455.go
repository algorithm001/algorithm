package id_103

import "sort"

func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	child, cookie := 0,0
	for child < len(g) && cookie < len(s){
		if g[child] <= s[cookie]{
			child++
		}
		cookie++
	}
	return child
}
