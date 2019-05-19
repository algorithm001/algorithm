/**
 * @param {number} N
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(N, trust) {
  if (N === 1 && trust.length > 0) {
    return -1
  }
  let peopleBeTrusted = new Array(N)
  for (let i = 0; i < peopleBeTrusted.length; i++) {
    peopleBeTrusted[i] = 0
  }
  for (let i = 0; i < trust.length; i++) {
    peopleBeTrusted[trust[i][0] - 1] = -1
    if (peopleBeTrusted[trust[i][1] - 1] !== -1) {
      peopleBeTrusted[trust[i][1] - 1]++
    }
  }
  let judge = []
  for (let i = 0; i < peopleBeTrusted.length; i++) {
    if (peopleBeTrusted[i] === N - 1) {
      judge.push(i)
    }
  }
  if (judge.length === 1) {
    return judge[0] + 1
  }
  return -1
};
