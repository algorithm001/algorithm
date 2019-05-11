class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];

        bfs(board, x, y);
        return board;
    }

    private void bfs(char[][] board, int x, int y) {
        if (!checkBound(board, x, y)) {
            return;
        }
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        int count = countMine(board, x, y);
        if (board[x][y] == 'E') {
            if (count == 0) {
                board[x][y] = 'B';
                bfs(board, x - 1, y - 1);
                bfs(board, x, y - 1);
                bfs(board, x + 1, y - 1);
                bfs(board, x - 1, y);
                bfs(board, x, y);
                bfs(board, x + 1, y);
                bfs(board, x - 1, y + 1);
                bfs(board, x, y + 1);
                bfs(board, x + 1, y + 1);
            } else {
                board[x][y] = (char) (count + 48);
            }
        }
    }

    private int countMine(char[][] board, int x, int y) {
        int count = 0;
        if (checkBound(board, x - 1, y - 1)) {
            if ('M' == board[x - 1][y - 1]) {
                count++;
            }
        }
        if (checkBound(board, x, y - 1)) {
            if ('M' == board[x][y - 1]) {
                count++;
            }
        }
        if (checkBound(board, x + 1, y - 1)) {
            if ('M' == board[x + 1][y - 1]) {
                count++;
            }
        }
        if (checkBound(board, x - 1, y)) {
            if ('M' == board[x - 1][y]) {
                count++;
            }
        }
        if (checkBound(board, x + 1, y)) {
            if ('M' == board[x + 1][y]) {
                count++;
            }
        }
        if (checkBound(board, x - 1, y + 1)) {
            if ('M' == board[x - 1][y + 1]) {
                count++;
            }
        }
        if (checkBound(board, x, y + 1)) {
            if ('M' == board[x][y + 1]) {
                count++;
            }
        }
        if (checkBound(board, x + 1, y + 1)) {
            if ('M' == board[x + 1][y + 1]) {
                count++;
            }
        }
        return count;
    }

    private boolean checkBound(char[][] board, int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }
}