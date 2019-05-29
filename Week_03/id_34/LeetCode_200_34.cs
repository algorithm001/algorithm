public class Solution {
       public int NumIslands(char[][] grid)
        {
            int islandCount = 0;
            for (int y = 0; y < grid.Length; y++)
            {
                for (int x = 0; x < grid[y].Length; x++)
                {
                    if (grid[y][x] == '1')
                    {
                        TraceIsland(grid, y, x);
                        islandCount++;
                    }
                }
            }

            return islandCount;
        }


        public void TraceIsland(char[][] grid, int y, int x)
        {
            if (y < 0 || x < 0 || y >= grid.Length || x >= grid[y].Length)
            {
                return;
            }
            if (grid[y][x] == '1')
            {
                grid[y][x] = '2';
                TraceIsland(grid, y + 1, x);
                TraceIsland(grid, y - 1, x);
                TraceIsland(grid, y, x + 1);
                TraceIsland(grid, y, x - 1);
            }
            else
            {
                return;
            }
        }
}
