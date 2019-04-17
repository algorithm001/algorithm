class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        int[] tempArray = new int[A.length];

        for(int i = 0, length = A.length, odd = 0, even = length - 1; i < length; i++){
            if (A[i] % 2 == 0) {
                tempArray[odd] = A[i];
                odd++;
            } else {
                tempArray[even] = A[i];
                even--;
            }
        }

        return tempArray;
    }
}
