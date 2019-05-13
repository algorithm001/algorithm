/**
 * 使用图论，求最短路径，通过队列使用BFS广度优先遍历
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
    if (n < 1) { return; }
    const queue = [[n, 0]]; // [[完全平方差, 步数]]
    const set = new Set(); // 保存访问过的节点
    set.add(n);
    while(queue.length != 0) {
      const el = queue.shift();
      const num = el[0];
      const step = el[1];
          
      if (num == 0) { // 找到最短路径
        return step;
      }
      
      for (let i = 1; ; i++) {
        const nn = num - i*i;
        if (nn < 0) { // num - i*i >= 0
          break;
        }
        if (!set.has(nn)) {
          queue.push([nn, step + 1]); // 保存节点和步数，节点是完全平方差
          set.add(nn);
        }
      }
    }
    return;
  };