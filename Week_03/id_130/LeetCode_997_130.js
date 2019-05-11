// https://leetcode.com/problems/find-the-town-judge/

/**
 * @param {number} N
 * @param {number[][]} trust
 * @return {number}
 */

var findJudge1 = function(N, trust) {
  const counts = new Array(N + 1).fill(0);
  for (let [i, j] of trust) {
    counts[i] -= 1;
    counts[j] += 1;
  }

  for (let i = 1; i < counts.length; i++) {
    if (N - 1 === counts[i]) {
      return i;
    }
  }

  return -1;
};

var findJudge = function(N, trust) {
  if (N === 1) return N;
  const mark = new Array(N).fill(true);
  const trustMark = {};

  for (let i = 0; i < trust.length; i++) {
    mark[trust[i][0] - 1] = false;
    if (trustMark[trust[i][1]]) {
      trustMark[trust[i][1]]++;
    } else {
      trustMark[trust[i][1]] = 1;
    }
  }

  for (let [key, value] of Object.entries(trustMark)) {
    if (value === N - 1 && mark[key - 1]) return key;
  }

  return -1;
};
