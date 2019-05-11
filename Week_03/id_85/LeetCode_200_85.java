public class LeetCode_200_85 {
}

/**
 * @Package:
 * @ClassName: NumberOfIslands
 * @Description: 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * **************一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * **************你可以假设网格的四个边均被水包围。
 * @leetcode url:https://leetcode-cn.com/problems/number-of-islands/comments/
 * @Author: wangzhao
 * @Date: 2019-05-05 14:02:46
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class NumberOfIslands {


    public int numIslands(char[][] grid) {

        if (grid==null||grid.length==0){
            return 0;
        }
        int res =0;
        int width = grid[0].length;
        int height = grid.length;

        boolean[][] visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j]=='1'&&!visited[i][j]){
                    res++;
                    dfs(grid,width,height,visited,i,j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int width, int height, boolean[][] visited, int i, int j) {

        if (i < 0 || i >= height || j < 0 || j >= width) {
            return;
        }
        if (grid[i][j]=='0'||visited[i][j]){
            return;
        }

        visited[i][j]=true;
        dfs(grid,width,height,visited,i-1,j);
        dfs(grid,width,height,visited,i+1,j);
        dfs(grid,width,height,visited,i,j-1);
        dfs(grid,width,height,visited,i,j+1);
    }


    public static void main(String[] args) {

        char[][] grid ={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        int num = new NumberOfIslands().numIslands(grid);

        System.out.println(num);
    }

}
