1，申请额外空间


//执行用时 : 3 ms, 在Sort Array By Parity的Java提交中击败了99.59% 的用户
//内存消耗 : 46.5 MB, 在Sort Array By Parity的Java提交中击败了68.41% 的用户

class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        int j = A.length;
        if (j<=1) return A;
        int[] B = new int[j];
        
        int x=0;
        int y=j-1;
        
        for(int i=0; i<j; i++){   //注意是i<j，而不是i<=j
            
            if(A[i]%2 != 0){
                B[y] = A[i];
                y--;
            }
            else{
                B[x] = A[i];
                x++;
            } 
        }
        return B;
    }
}



2，不利用额外空间，前后指针，交换
class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        if(A == null || A.length == 1) return A;
        int j = A.length - 1;
        int i = 0;
        
        while(i<=j){  //注意不是i！=j，比如数组长度为2，会导致越界
            if(A[i]%2!=0 && A[j]%2==0){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
            else{
                if(A[i]%2==0) i++;   
                if(A[j]%2!=0) j--;
            }
        }
        return A;
    }
}