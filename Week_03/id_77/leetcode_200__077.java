class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    mark(i,j,grid);
                }
            }
        }
        return count;
        
    }
    
    public void mark(int x,int y,char[][] grid){
        if(x<0 || y<0){
            return;
        }
        
        if(x == grid.length){
            return;
        }
        if(y == grid[x].length){
            return;
        }
        if(grid[x][y] != '1'){
            return;
        }else{
            grid[x][y] = 'x';
            mark(x,y-1,grid);
            mark(x,y+1,grid);
            mark(x+1,y,grid);
            mark(x-1,y,grid);
            
        }
    }
}