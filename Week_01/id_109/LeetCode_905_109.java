
/**
 * @Auther: quanhc
 * @Date: 2019-04-20 21:17
 * @Description:
 */
public class LeetCode905 {

    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int j = A.length-1;
        int k = 0;
        for (int i=0;i < A.length;i++){
            if (A[i]%2==0){
                result[k] = A[i];
                k++;
            }else{
                result[j] = A[i];
                j--;
            }
        }
        return result;
    }

    /**
     * 双指针.但不知为啥从空间和时间复杂度 都没有额外的数组快
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int k = A.length-1;

        while( i<k){
            if (A[i]%2!=0&&A[k]%2==0){
                int tmp = A[i];
                A[i] = A[k];
                A[k] = tmp;
                continue;
            }
            if (A[i]%2==0){
                i++;
            }
            if (A[k]%2!=0){
                k--;
            }

        }
        return A;
    }
}
