class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        //初始化左右指针
        int left = 0,right = A.length - 1;
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                res[left] = A[i];
                left = left + 1;
            } else {
                res[right] = A[i];
                right = right - 1;
            }
        }
        return res;
    }
}