//https://leetcode.com/problems/sort-array-by-parity-ii/
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length <= 1)
            return A;
        int even = 0, odd = 1;
        while (even < A.length && odd < A.length) {
            if ((A[even] & 1) == 0) {
                even += 2;
                continue;
            }
            if ((A[odd] & 1) == 1) {
                odd += 2;
                continue;
            }
            int tmp = A[even];
            A[even] = A[odd];
            A[odd] = tmp;
            even += 2;
            odd += 2;
        }
        return A;
    }
}