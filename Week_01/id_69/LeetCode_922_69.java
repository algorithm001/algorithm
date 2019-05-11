class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        int j = 0;
        int k = 1;
        int[] tempArray = new int[A.length];

        for(int i = 0; i < length; i++){
            if ((A[i] & 1) == 0) {
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
