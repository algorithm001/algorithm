class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        int i=0,j=1;
        while(i < length){
            if(A[i] % 2 == 0){
                i+=2;
            }else {
                while(A[j] %2 != 0){
                    j+=2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}