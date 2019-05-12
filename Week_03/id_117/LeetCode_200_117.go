package solution

import "fmt"

/*
200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

// 思路一： DFS
func numIslands(grid [][]byte) int {
	if grid == nil || len(grid) == 0 || len(grid[0]) == 0 {
		return 0
	}
	fn := "numIslands"
	fmt.Println(fn, grid)
	rowLen := len(grid)
	columnLen := len(grid[0])
	count := 0
	for m := 0; m < rowLen; m++ {
		for n := 0; n < columnLen; n++ {
			if grid[m][n] == '1' {
				count++
				numIslandsCell(grid, m, n)
			}
		}
	}
	resetIslands(grid)
	return count
}

func numIslandsCell(grid [][]byte, i, j int) {
	rowLen := len(grid)
	columnLen := len(grid[0])
	if grid[i][j] != '1' {
		return
	}
	grid[i][j] = 'M'
	if i > 0 {
		numIslandsCell(grid, i-1, j)
	}
	if j > 0 {
		numIslandsCell(grid, i, j-1)
	}
	if j < columnLen-1 {
		numIslandsCell(grid, i, j+1)
	}
	if i < rowLen-1 {
		numIslandsCell(grid, i+1, j)
	}
}

func resetIslands(grid [][]byte) {
	rowLen := len(grid)
	columnLen := len(grid[0])
	for i := 0; i < rowLen; i++ {
		for j := 0; j < columnLen; j++ {
			if grid[i][j] == 'M' {
				grid[i][j] = '0'
			}
		}
	}
}

// 思路二： 并查集
// golang中byte和int转换
func numIslands2(grid [][]byte) int {
	rowLen := len(grid)
	columnLen := len(grid[0])
	eles := initialEle(grid)
	// 从上到下，从左到右开始比较元素
	for i := 0; i < rowLen; i++ {
		for j := 0; j < columnLen; j++ {
			if grid[i][j] == '1' {
				// 当前位置
				curEleIdx := i*columnLen + j
				// 比较当前元素和右边元素
				if j < columnLen-1 && grid[i][j+1] == '1' {
					nextEleIdx := i*columnLen + (j + 1)
					joinEle(eles, curEleIdx, nextEleIdx)
				}
				// 比较当前元素和下面元素
				if i < rowLen-1 && grid[i+1][j] == '1' {
					nextEleIdx := (i+1)*columnLen + j
					joinEle(eles, curEleIdx, nextEleIdx)
				}
			}
		}
	}
	return countEle(eles)
}

func initialEle(grid [][]byte) *[]int {
	rowLen := len(grid)
	columnLen := len(grid[0])
	result := make([]int, rowLen*columnLen)
	for i := 0; i < rowLen; i++ {
		for j := 0; j < columnLen; j++ {
			curIdx := i*columnLen + j
			if grid[i][j] == '0' {
				result[curIdx] = -1
			} else {
				result[curIdx] = curIdx
			}
		}
	}
	fmt.Println(result)
	return &result
}

func joinEle(eles *[]int, cur, next int) {
	if (*eles)[cur] != (*eles)[next] {
		(*eles)[next] = (*eles)[cur]
	}
}

func countEle(eles *[]int) int {
	elesLen := len(*eles)
	mps := make(map[int]int)
	for i := 0; i < elesLen; i++ {
		ele := (*eles)[i]
		if ele == -1 {
			continue
		}
		if _, ok := mps[ele]; ok {
			continue
		} else {
			mps[ele] = 1
		}
	}
	return len(mps)
}
