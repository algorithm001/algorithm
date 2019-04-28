class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < A.length && j > 0) {
            int a = A[i], b = A[j];

            if (a % 2 == 1) {
                if (b % 2 == 0) { // W-W
                    // swap
                    A[i] = b;
                    A[j] = a;
                    // walk both
                    i += 2;
                    j -= 2;
                } else { // W-R
                    j -= 2;
                }
            } else {
                if (b % 2 == 0) { // R-W
                    i += 2;
                } else { // R-R
                    i += 2;
                    j -= 2;
                }
            }
        }
        return A;
    }
}
