package leetcode.Algorithms._101_200._200_NumberOfIslands;

/**
 * Created by jialei.zou on 2019/5/5 .
 ref:
 https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length<1){
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if(visited[i][j] == false && grid[i][j] =='1'){
                    count = count+1;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return count;

    }

    private void dfs(int i, int j,char[][] grid, boolean[][] visited){
        if((i<0 || i>=visited.length)||(j<0 || j>=visited[0].length) || visited[i][j] == true || grid[i][j]=='0'){
            return;
        }
        visited[i][j]=true;
        dfs(i+1, j, grid, visited);
        dfs(i-1, j, grid, visited);
        dfs(i, j+1, grid, visited);
        dfs(i, j-1, grid, visited);
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(
                new char[][]{
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                }
        ));

        System.out.println(numberOfIslands.numIslands(
                new char[][]{
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                }
        ));
    }
}
