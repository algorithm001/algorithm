class Solution {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        int i = 0;
        int j = len-1;
        
        while(i < j){  
            if(A[i]%2 == 1 && A[j]%2 == 0){
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i++;
                j--;
            }
            
            if(A[i]%2 == 0) i++;
            if(A[j]%2 == 1) j--;
        }
        return A;
    }
}