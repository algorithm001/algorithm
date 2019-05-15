/**
 * 51. N皇后
 * https://leetcode-cn.com/problems/n-queens/
 * 递归，回溯
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    const col = new Array(n).fill(false); 
    const dia1 = new Array(2*n - 1).fill(false); 
    const dia2 = new Array(2*n - 1).fill(false); 
    
    // 尝试在一个 n 皇后问题中，摆放第 index 行的皇后位置
    function putQueen(n, index, row) {
      if (index == n) {
        res.push(generateBoard(n, row));
      }
      
      for (let i = 0; i < n; i++) {
        // 尝试将第index行的皇后放到第i列
        if (!col[i] && !dia1[index + 1] && !dia2[index - n - 1]) {
          // 开始递归
          row.push(i);
          col[i] = true;
          dia1[index + i] = true;
          dia2[index - i + n - 1] = true;
          putQueen(n, index + 1, row);
          
          // 开始回溯
          col[i] = false;
          dia1[index + i] = false;
          dia2[index - i + n - 1] = false;
          row.pop();
        }
      }
      return;
    }
    
    function generateBoard(n, row) {
      // 初始化 n 个 string 每个 string n 个 '.'
      const board = new Array(n).fill(new Array(n).fill('.').join(''));
      for (let i = 0; i < n; i++) {
        const s = board[i].split('');
        s[row[i]] =  'Q';
        board[i] = s.join('');
      }
      return board;
    }
    
    const res = [];
    const row = [];
    putQueen(n, 0, row);
    
    return res;
  };