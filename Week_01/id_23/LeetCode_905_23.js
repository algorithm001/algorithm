/**
 * https://leetcode.com/problems/sort-array-by-parity/
 *  @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParity = function(A) {
  let startPoint = 0;
  let endPoint = A.length - 1;

  const isEven = item => item % 2 === 0;

  while (startPoint < endPoint) {
    if (isEven(A[startPoint])) {
      startPoint++;
      continue;
    }
    if (!isEven(A[endPoint])) {
      endPoint--;
      continue;
    }

    [A[startPoint], A[endPoint]] = [A[endPoint], A[startPoint]];
    startPoint++;
    endPoint--;
  }

  return A;
};
