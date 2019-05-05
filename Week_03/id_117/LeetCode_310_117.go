package solution

import (
	"fmt"
)

/*
310. Minimum Height Trees

For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :

Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3

Output: [1]
Example 2 :

Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5

Output: [3, 4]
Note:

According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
*/

// 方法一：DFS，待实现
func findMinHeightTrees(n int, edges [][]int) []int {
	ans := make([]int, 0)
	heights := make([]int, 0)
	for _, item := range edges {
		maxH := computeMaxHeight(edges, item)
		if len(heights) == 0 {
			heights = append(heights, maxH)
			ans = append(ans, item[0])
		} else {
			top := heights[0]
			if top < maxH {
				ans = []int{item[0]}
				heights = []int{top}
			}
			if top == maxH {
				ans = append(ans, item[0])
			}
		}
	}
	return ans
}

func computeMaxHeight(edges [][]int, row []int) int {
	// [TODO]
	return 0
}

// 方法二：BFS，待实现
func findMinHeightTrees2(n int, edges [][]int) []int {
	mps := make(map[int]int)
	ans := make([]int, 0)
	// 使用数组中的元素分别跟节点遍历
	min := n
	// 构造函数计算从某个数字开始的分支
	modified := adjustList(n, edges)
	fmt.Println("modified =>", modified)
	for k := range modified {
		// BFS遍历
		path := make(map[int]bool)
		computeBfsMax(modified, &path, k)
		fmt.Println("fromMax =>", path, k)
		mps[k] = len(path)
	}

	// 获取元素
	for k, v := range mps {
		if min > v {
			ans = make([]int, 0)
			min = v
			ans = append(ans, k)
		} else if min == mps[k] {
			ans = append(ans, k)
		}
	}
	fmt.Println("min ====>", min)
	return ans
}

func contains(modified [][]int, idx, element int) bool {
	for _, e := range modified[idx] {
		if e == element {
			return true
		}
	}
	return false
}

func computeBfsMax(modified [][]int, shortPath *map[int]bool, idx int) int {
	// modified => [[3] [3] [3] [0 1 2 4] [3 5] [4]]
	(*shortPath)[idx] = true
	num := 0
	for _, v := range modified[idx] {
		if (*shortPath)[v] {
			continue
		}
		num = computeBfsMax(modified, shortPath, v) + 1
	}
	return num
}

func adjustList(n int, edges [][]int) [][]int {
	modified := make([][]int, 0)
	for i := 0; i < n; i++ {
		vals := []int{}
		for _, ele := range edges {
			if ele[0] == i {
				vals = append(vals, ele[1])
			}
			if ele[1] == i {
				vals = append(vals, ele[0])
			}
		}
		modified = append(modified, vals)
	}
	return modified
}

// 方法三：BFS
// 摘自： https://leetcode.com/problems/minimum-height-trees/discuss/285896/golang-bfs
func findMinHeightTrees3(n int, edges [][]int) []int {
	if n <= 1 {
		return []int{0}
	}

	adjacentMap := make(map[int]map[int]bool)
	for i := 0; i < n; i++ {
		adjacentMap[i] = make(map[int]bool)
	}
	for _, edge := range edges {
		a, b := edge[0], edge[1]
		adjacentMap[a][b] = true
		adjacentMap[b][a] = true
	}
	queue := []int{} // 保存最外层叶子节点
	for i := 0; i < n; i++ {
		if len(adjacentMap[i]) == 1 {
			queue = append(queue, i)
		}
	}

	for len(queue) > 0 {
		// 如果只剩余最后两个,则两个都是正确值,直接返回
		if len(queue) == 2 {
			a, b := queue[0], queue[1]
			if adjacentMap[a][b] && adjacentMap[b][a] {
				// 两个节点的返回
				fmt.Println("two ends")
				return queue
			}
		}

		next := []int{}
		// 每一次循环都是删除叶子节点
		for _, node := range queue {
			// neighbor为叶子节点关联的直接节点
			for neighbor := range adjacentMap[node] {
				// 直接节点没有其他的关联节点
				if len(adjacentMap[neighbor]) == 1 {
					// 一个节点的返回
					fmt.Println("one ends")
					return []int{neighbor}
				}
				delete(adjacentMap[neighbor], node)
				delete(adjacentMap[node], neighbor)
				if len(adjacentMap[neighbor]) == 1 {
					next = append(next, neighbor)
				}
			}
		}
		queue = next
	}
	return []int{}
}
