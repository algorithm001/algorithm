class Solution {
    public int[] sortArrayByParityII(int[] A) {
        
        
        int[] res = new int[A.length];
        
        int x = 0;
        for(int i=0;i<A.length;i++){    
            if (A[i] % 2 == 0) {
                res[x] = A[i];
                x += 2;
            }
        }

        x = 1;
        for (int j=0;j<A.length;j++ ){
            
            if (A[j] % 2 == 1) {
                res[x] = A[j];
                x += 2;
            }
        }
        return res;
        
    }
}
