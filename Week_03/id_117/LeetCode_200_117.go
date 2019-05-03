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
	fn := "numIslands"
	fmt.Println(fn, grid)
	rowLen := len(grid)
	columnLen := len(grid[0])
	count := 0
	for m := 0; m < rowLen; m++ {
		for n := 0; n < columnLen; n++ {
			if grid[m][n] == 1 {
				count++
				numIslandsCell(grid, m, n)
			}
		}
	}
	// 江湖句排序输出
	resetIslands(grid)
	return count
}

func numIslandsCell(grid [][]byte, i, j int) {
	rowLen := len(grid)
	columnLen := len(grid[0])
	if grid[i][j] != 1 {
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
				grid[i][j] = '1' - 48
			}
		}
	}
}

// 思路二： 并查集
