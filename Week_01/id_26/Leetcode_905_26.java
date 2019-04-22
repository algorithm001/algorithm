// Source : https://leetcode.com/problems/sort-array-by-parity/
// Id     : 905
// Author : Fanlu Hai
// Date   : 2018-04-15

import java.util.Arrays;

class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (j > i) {
//            System.out.println(Arrays.toString(A));
            if (A[i] % 2 == 1 && A[j] % 2 == 0) {
                swapNumInArray(i, j, A);
            }

            if (A[i] % 2 == 0) {
                i++;
                //in order to make sure a check is performed
                continue;
            }

            if (A[j] % 2 == 1) {
                j--;
                //in order to make sure a check is performed
                continue;
            }
        }
        return A;
    }

    public void swapNumInArray(int firstIndex, int secondIndex, int[] array) {
        int tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }

    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] a = {1, 1, 1, 1, 2, 2, 2, 3, 3, 33, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7, 7, 8};
        System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(a)));
    }
}
