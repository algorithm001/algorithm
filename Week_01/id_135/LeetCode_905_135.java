class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A == null || A.length == 1)
            return A;
        int x = 0;
        int y = A.length - 1;
        int[] res = new int[A.length];
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                res[x++] = A[i];
            }else{
                res[y--] = A[i];
            }
        }
        return res;      
    }
}