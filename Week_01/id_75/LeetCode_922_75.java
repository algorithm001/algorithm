class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int oddIndex = 0;
        int evenIndex = 1;
        int[] res = new int[A.length];
        for(int i = 0;i < A.length; i++){
            if(A[i] % 2 == 0){
                res[oddIndex] = A[i];
                oddIndex = oddIndex + 2;
            } else {
                res[evenIndex] = A[i];
                evenIndex = evenIndex + 2;
            }
        }
        return res;
    }
}