class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    marking(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void marking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }
        
        grid[i][j] = '0';
        marking(grid, i + 1, j);
        marking(grid, i - 1, j);
        marking(grid, i, j + 1);
        marking(grid, i, j - 1);
    }
}