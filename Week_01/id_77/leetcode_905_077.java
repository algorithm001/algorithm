class Solution {
        
    
    public int[] sortArrayByParity(int[] A) {
        int[] arr =new  int[A.length];
        int start = -1, end = A.length;
        for(int i=0;i<A.length;i++){
            if(A[i] % 2 == 0){
                arr[++start]=A[i];
            }else{           
               arr[--end]=A[i];
            }
            if((start+1) == end){
                return arr;
            } 
        }
        return arr;
    } 
  
}