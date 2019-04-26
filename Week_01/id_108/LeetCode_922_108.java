/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/20
 */
public class LeetCode_922_108 {
    class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int oddIndex = 1;
            int evenIndex = 0;
            int[] tmp = new int[A.length];
            for(int i= 0;i<A.length;i++){
                if((A[i] & 1) == 0){
                    tmp[evenIndex] = A[i];
                    evenIndex = evenIndex + 2;
                }else{
                    tmp[oddIndex] = A[i];
                    oddIndex = oddIndex + 2;
                }
            }
            return tmp;
        }
    }
}
