/**
 * 784. 字母大小写全排列
 * https://leetcode-cn.com/problems/letter-case-permutation/
 * 深度优先DFS 递归 https://user-images.githubusercontent.com/49065208/56465164-f0a10800-642a-11e9-81a0-5894bb030e6f.png
 * dfs(arr, i):
 *   if i == str.length: res.push(str.json(''))
 *   dfs(arr, i + 1)
 *   if arr[i] is letter:
 *      toggleCase(arr[i])
 *      dfs(arr, i + 1)
 *      toggleCase(arr[i]) // toggle back case
 * 
 * @param {string} S
 * @return {string[]}
 */
var letterCasePermutation = function(S) {
  const result = [];
  function toggleCase(s) {
      if (/[A-Z]/.test(s)) {
          return s.toLowerCase();
      } else {
          return s.toUpperCase();
      }
  }
  
  function dfs(arr, i, res) {
      if (i == arr.length) {
          res.push(arr.join(''));
          return;
      }
      dfs(arr, i + 1, res);
      if(/\d/.test(arr[i])) { return; } // is number
      arr[i] = toggleCase(arr[i]); // transform to upper/lower case
      dfs(arr, i + 1, res);
      arr[i] = toggleCase(arr[i]);// transform back to upper/lower case
  }
  
  dfs(S.split(''), 0, result);
  
  return result;
};