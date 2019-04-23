/**
 * https://leetcode-cn.com/problems/sort-array-by-parity/submissions/
 */

class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        // 1. 边界处理，长度 <=1 什么都不做
        if(A.length<=1){
            return A;
        }
        
        // 2. 定义前后索引
        int left = 0;
        int right = A.length-1;
        
        // 3. 移动元素
        while(left<right){
            // 若，左侧奇数，右侧偶数，则交换元素。
            if(isOdd(A[left]) && isEven(A[right])){
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }else{
                // 左侧是偶数，则右移一位
                if(isEven(A[left])){
                    left++;
                }
                // 右侧是奇数，则左移一位
                if(isOdd(A[right])){
                    right--;
                }                
            }
        }
        return A;
    }
    
    // 是否为偶数
    boolean isEven(int x){
        return x%2==0;
    }    
    // 是否为奇数
    boolean isOdd(int x){
        return x%2!=0;
    }
}
