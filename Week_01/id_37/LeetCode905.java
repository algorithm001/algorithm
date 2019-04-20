class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res=new int[A.length];
        int left=0;
        int right=A.length-1;
        
        for(int i=0;i<A.length;i++){
            
            if(A[i]%2==0){
                res[left]=A[i];
                left++;
            }else{
                res[right] = A[i];
                right--;
            }
            
        }
        
        return res;
    }
}
