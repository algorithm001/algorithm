class Solution {
    public int[] sortArrayByParityII2(int[] A) {
        int[] result=new int[A.length];
        int j=0;
        int k=1;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                result[j]=A[i];
                j=j+2;
            }else{
                result[k]=A[i];
                k=k+2;
            }
        }
        return result;
    }
}
