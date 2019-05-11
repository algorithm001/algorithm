/**
 * 905. 按奇偶排序数组
 * https://leetcode-cn.com/problems/sort-array-by-parity/submissions/
 * 双指针解法，左指针指偶数，右指针指奇数
 * @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParity = function(A) {
    if (A == null || A.length <= 1) { return A; } 
    let l = 0; // 偶数左指针
    let r = A.length - 1; // 奇数右指针
    while(l < r) {
        // 
        if (A[l] % 2 == 1 && A[r] % 2 == 0) {
            [A[l], A[r]] = [A[r], A[l]];
        } else if (A[l] % 2 == 0) {
            l++; // 偶数指针右移
        } else if (A[r] % 2 == 1) {
            r--; // 奇数指针左移
        }
        
    }
    
    return A;
};