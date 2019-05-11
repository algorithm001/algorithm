class Solution {
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; ) {
            if (!isOdd(A[i])) {
                if (isOdd(A[j])) {//i偶j奇
                    ++i;
                    --j;
                } else {//i偶j偶
                    ++i;
                }
            } else {
                if (isOdd(A[j])) {//i奇j奇
                    --j;
                } else {//i奇j偶
                    int tmp = A[j];
                    A[j] = A[i];
                    A[i] = tmp;
                }
            }
        }
        return A;
    }

    public boolean isOdd(int number) {
        if (number % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

}