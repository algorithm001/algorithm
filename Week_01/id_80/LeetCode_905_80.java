class Solution {
    public int[] sortArrayByParity(int[] A) {
        int length=A.length;
        if(length>=1&&length<=5000){
            int[] B=new int[length];
            int l=0;
            int r=0;
            for(int i=0;i<length;i++){
                    int value=A[i];
                    //如果为奇数 放到后面
                    if(value%2==1){
                        B[length-1-l]=value;   
                        l++;
                        
                    }else{
                        B[r]=value;
                        r++;
                        
                    }
            }
            return B;
        }
        return null;
    }
}