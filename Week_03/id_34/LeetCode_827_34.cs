public class Solution {
        public class IslandSqurePoint
        {
            public int x;
            public int y;
            public IslandSqurePoint(int y,int x)
            {
                this.y = y;
                this.x = x;
            }
        }

        public class IslandInfo
        {
            public int IslandSize;
            public List<IslandSqurePoint> GroundList = new List<IslandSqurePoint>();
            public List<IslandSqurePoint> WaterEdgeList = new List<IslandSqurePoint>();
        }

        List<IslandInfo> islandList = new List<IslandInfo>();

        public int LargestIsland(int[][] grid)
        {
            //解题思路：先找出岛屿的个数，再找出岛屿边缘水域，再找岛屿之间的边缘水域是否有重合，有的话即能链接在一起
            //目前性能不好，有时候报超时，有时候能通过，待优化
            int maxAra = 0;
            int gridSize = grid.Length * grid[0].Length;
            for(int y=0;y<grid.Length;y++)
            {
                for(int x=0;x<grid[y].Length;x++)
                {
                    if(grid[y][x]==1)
                    {
                        IslandInfo ii = new IslandInfo();
                        TraceIsland(grid, y, x, ii);
                        FindEdgeWater(ii,grid);
                        if(ii.IslandSize>maxAra)
                        {
                            maxAra = ii.IslandSize;
                        }
                        islandList.Add(ii);
                    }
                }
            }
            if (maxAra == gridSize)
            {
                return gridSize;
                
            }else
            {
                maxAra += 1;
            }
            for (int y = 0; y < grid.Length; y++)
            {
                for (int x = 0; x < grid[y].Length; x++)
                {
                    if (grid[y][x] == 0)
                    {
                        int totalArea = 0;
                        foreach (var item in islandList)
                        {
                            if (item.WaterEdgeList.Where(p => p.x == x && p.y == y).ToList().Count >= 1)
                            {
                                totalArea += item.IslandSize;
                            }
                        }
                        totalArea += 1;
                        if (totalArea > maxAra)
                        {
                            maxAra = totalArea;
                        }
                    }
                }
            }
            return maxAra;
        }

        public void FindEdgeWater(IslandInfo iland,int[][] grid)
        {
            foreach(var item in iland.GroundList)
            {
                if(iland.GroundList.Where(p=>p.x==item.x&&p.y==item.y-1).ToList().Count==0)
                {
                    iland.WaterEdgeList.Add(new IslandSqurePoint(item.y-1, item.x));
                }

                if (iland.GroundList.Where(p => p.x == item.x && p.y == item.y + 1).ToList().Count == 0)
                {
                    iland.WaterEdgeList.Add(new IslandSqurePoint( item.y + 1, item.x));
                }

                if (iland.GroundList.Where(p => p.x == item.x-1 && p.y == item.y).ToList().Count == 0)
                {
                    iland.WaterEdgeList.Add(new IslandSqurePoint( item.y, item.x - 1));
                }

                if (iland.GroundList.Where(p => p.x == item.x+1 && p.y == item.y).ToList().Count == 0)
                {
                    iland.WaterEdgeList.Add(new IslandSqurePoint( item.y, item.x + 1));
                }
            }
        }

        public void TraceIsland(int[][] grid, int y,int x,IslandInfo ilandInfo)
        {
            if(y<0||x<0||y>=grid.Length||x>=grid[y].Length)
            {
                return;
            }
           if(grid[y][x]==1)
            {
                grid[y][x] = 2;
                ilandInfo.IslandSize++;
                ilandInfo.GroundList.Add(new IslandSqurePoint(y, x));
                TraceIsland(grid, y + 1, x, ilandInfo);
                TraceIsland(grid, y - 1, x, ilandInfo);
                TraceIsland(grid, y, x + 1, ilandInfo);
                TraceIsland(grid, y, x - 1, ilandInfo);
            }
            else
            {
                return;
            }
        }
}
