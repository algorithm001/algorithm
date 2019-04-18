/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    public int search(int[] A, int target) {
        // 非递归
        
        // 边界处理
        if(A.length<1){
            return -1;
        }
        
        // 定义左右索引
        int left =0;
        int right = A.length-1;
        
        // 折半搜索。需要特别注意，用 >= 还是 >，用 left=mid 还是 left=mid+1。十分重要！！！
        while(left <= right){
            int mid = (left+right)/2;
            
            if(A[mid] == target){
                return mid;
            }
            
            if(A[mid] < A[right]){
                if(target>A[mid] && target<=A[right]){
                    left=mid+1;
                }
                else{
                    right = mid-1;
                }
            }else{
                if(target>=A[left] && target<A[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        // 没找到
        return -1;
    }
    
}
