class Solution {
    
    public int[] sortArrayByParity(int[] A) {
        if(A==null){
            return A;
        }
        // 记录数组两个指针位置 i,j 
        
        int i=0;
        int j=A.length-1;
        int tmp;
        // i是从开始慢慢递增,j是从末尾慢慢递减 
        // 如果i<j 则开始循环  
        while(i<j){
            //    如果i所在元素是偶数 则i++
            if((A[i]&1)==0){
                i++;
            }else{
             //    如果i所在元素是奇数 则i和j元素互换 j--  
                tmp=A[i];
                A[i]=A[j];
                A[j]=tmp;
                j--;
            }
        }
       
        return A;          
        
    }
}