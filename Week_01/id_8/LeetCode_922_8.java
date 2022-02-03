class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int p = 0;
        int q = 1;
        while (p < A.length && q < A.length) {
            if (isOddNum(A[p])) {
                if (isOddNum(A[q])) {
                    q += 2;
                } else {
                    int tmp = A[q];
                    A[q] = A[p];
                    A[p] = tmp;

                    p += 2;
                    q += 2;
                }
            } else {
                if (isOddNum(A[q])) {
                    p += 2;
                    q += 2;

                } else {
                    p += 2;
                }

            }
        }
        return A;
    }


private static boolean isOddNum(int num) {
    return (num & 0x0001) == 1;
}
}
