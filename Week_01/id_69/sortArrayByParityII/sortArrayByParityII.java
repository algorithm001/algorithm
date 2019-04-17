class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] tempArray = new int[A.length];

        for(int i = 0, length = A.length, j = 0, k = 1; i < length; i++){
            if (A[i] % 2 == 0) {
                tempArray[j] = A[i];
                j += 2;
            } else {
                tempArray[k] = A[i];
                k += 2;
            }
        }

        return tempArray;
    }
}
