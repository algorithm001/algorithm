/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/20
 */
public class LeetCode_905_108 {
    class Solution1 {
        public int[] sortArrayByParity(int[] A) {
            int left = 0;
            int right = A.length - 1;
            while(left < right){
                while( left< A.length && (A[left] & 1) == 0){
                    left ++;
                }
                while( right>0 && (A[right] & 1) == 1){
                    right --;
                }
                if(left < right) {
                    swap(A,left,right);
                }
            }
            return A;
        }

        private void swap(int[] A,int left,int right){
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
        }
    }

    class Solution2 {
        public int[] sortArrayByParity(int[] A) {
            int[] even = new int[A.length];
            int[] odd = new int[A.length];
            int evenIndex = 0;
            int oddIndex = 0;
            for(int i=0 ;i<A.length;i++){
                if((A[i] & 1) == 0){
                    even[evenIndex ++] = A[i];
                }else{
                    odd[oddIndex ++] = A[i];
                }
            }
            for(int i=0 ;i<oddIndex;i++){
                even[evenIndex ++] = odd[i];
            }
            return even;
        }
    }
}
