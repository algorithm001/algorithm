/**
 * 200. 岛屿的个数
 * https://leetcode-cn.com/problems/number-of-islands/
 * DFS, Floodfill 填充法
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
  if (grid.length == 0) { return 0; }
  const d = [[0, 1], [1, 0], [0, -1], [-1, 0]]; // 非顺时针方向
  const m = grid.length;
  const n = grid[0].length;
  const visited = Array(m).fill().map(() => Array(n).fill(false)); //[[false...],...] 保存元素是否被访问过
  
  
  // 判断是否越界
  function inArea(x, y) {
    return x >=0 && x < m && y >=0 && y < n;
  }
  
  // 从grid[x][y] 的位置开始，进行 floodfill
  // 保证 (x, y) 合法， 且 grid[x][y]是没有被访问过的陆地
  function dfs(grid, x, y) {
    visited[x][y] = true;
    for (let i = 0; i < 4; i++) {
      const newx = x + d[i][0];
      const newy = y + d[i][1];
      if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
        dfs(grid, newx, newy);
      }      
    }
  }
  
  let res = 0;
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] == '1' && !visited[i][j]) {
        res++;
        dfs(grid, i, j);
      }
    }
  }
  
  return res;
};