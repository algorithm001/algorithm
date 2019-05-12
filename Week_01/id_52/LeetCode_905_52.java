class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] result=new int[A.length];
        int j=0;
        int k=A.length-1;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                result[j]=A[i];
                j++;
            }else{
                result[k]=A[i];
                k--;
            }
        }
        return result;
    }
}
