class Solution {
    
    public int[] sortArrayByParityII(int[] A) {
        int[] arr = new int[A.length];
        int evenStart = -2, oddStart = -1;
        for(int i=0;i<A.length;i++){
            if(A[i] % 2 == 0){
                evenStart += 2;
                arr[evenStart] = A[i];
            }else{   
                oddStart += 2;
                arr[oddStart] = A[i];
            }
        }
        return arr;
    }
}