class Solution {
	public  boolean exist(char[][] board, String word) {
    if(board == null || board.length == 0 || board[0].length == 0){
   	 return false;
    }
    int m = board.length; 
    int n = board[0].length;
    char[][] visited = new char[m][n];
    for(int i =0 ; i < m; i++){
   	 for(int j = 0; j < n ; j++){
   		 if(search(board,word,0,i,j,visited))
                return true;
   	 }
    }

    
    return false;
   }
   public boolean search(char[][] board, String word, int pos, int i, int j, char[][] visited)
   {
       if(pos == word.length())
           return true;
       int m = board.length, n = board[0].length;
       if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]==1 || board[i][j] != word.charAt(pos))
           return false;
       visited[i][j] = 1;
       boolean res = search(board, word, pos + 1, i - 1, j, visited) 
                || search(board, word, pos + 1, i + 1, j, visited)
                || search(board, word, pos + 1, i, j - 1, visited)
                || search(board, word, pos + 1, i, j + 1, visited);
       visited[i][j] = 0;
       return res;
   }
}}