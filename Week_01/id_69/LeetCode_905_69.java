class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        int length = A.length;
        int odd = 0;
        int even = length - 1;
        int[] tempArray = new int[length];
       
        for(int i = 0; i < length; i++){
            if ((A[i] & 1) == 0) {
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
