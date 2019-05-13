class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int p = 0;
        int q = A.length - 1;
        while (p - q < 0) {
            if (isOddNum(A[p])) {
                if (isOddNum(A[q])) {
                    --q;
                } else {
                    int tmp = A[q];
                    A[q] = A[p];
                    A[p] = tmp;

                    ++p;
                    --q;
                }
            } else {
                if (isOddNum(A[q])) {
                    ++p;
                    --q;
                } else {
                    ++p;
                }
            }
        }

        return A;
        
    }

    private boolean isOddNum(int num) {
        return (num & 0x0001) == 1;
    }
}