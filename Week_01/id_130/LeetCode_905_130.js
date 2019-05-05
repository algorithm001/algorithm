// https://leetcode.com/problems/sort-array-by-parity/
/**
 * @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParity = function(A) {
    const result = [];
    for (let i = 0; i < A.length; i++) {
        const currentVal = A[i];
        if (A[i] % 2 === 1) {
            result.push(currentVal);
        } else {
            result.unshift(currentVal);
        }
    }
    return result;
};
