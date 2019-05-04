// Source : https://leetcode.com/problems/sort-array-by-parity-ii/
// Id     : 922
// Author : Fanlu Hai
// Date   : 2018-04-15

import java.util.Arrays;

class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        while (true) {
//            System.out.println(A.length + " " + i + " " + j + " " + Arrays.toString(A));

            if (i >= A.length || j >= A.length) {
                return A;
            }

            if (A[i] % 2 == 1 && A[j] % 2 == 0) {
                swapNumInArray(i, j, A);
            }

            if (A[i] % 2 == 0) {
                i += 2;
                //in order to make sure a check is performed
                continue;
            }

            if (A[j] % 2 == 1) {
                j += 2;
                //in order to make sure a check is performed
                continue;
            }

        }

    }

    public void swapNumInArray(int firstIndex, int secondIndex, int[] array) {
        int tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] a = {1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 2, 2};
        System.out.println(Arrays.toString(sortArrayByParityII.sortArrayByParityII(a)));
    }
}
