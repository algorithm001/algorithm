public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int length = A.length;
        for (int i = 0, j = length - 1; i < j; ) {
            if (A[i] % 2 != 0 && A[j] % 2 != 1) {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                i++;
                j--;
            } else if (A[i] % 2 == 0) {
                i++;
            } else if (A[j] % 2 == 1) {
                j--;
            }
        }
        return A;

    }

    private boolean isOdd(int num) {
        return num % 2 == 0;
    }

    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        if (length < 2) {
            return A;
        }
        for (int i = 0, j = 1; i < length && j < length; ) {
            if (isOdd(i) && isOdd(A[i])) {
                i += 2;
            }else if (!isOdd(j) && !isOdd(A[j])) {
                j += 2;
            }else {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                i+=2;
                j+=2;
            }

        }
        return A;
    }


}
