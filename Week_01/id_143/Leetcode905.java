public class Leetcode905 {

    public int[] sortArrayByParity(int[] A) {

        if(A==null || A.length==1){
            return A;
        }

        int left=0;

        int right=A.length-1;

        while(left<right){

            if((A[left]%2)==1 && (A[right]%2)==0){
                int tmp=A[left];
                A[left]=A[right];
                A[right]=tmp;
            }
            if(A[left]%2==0){
                left++;
            }
            if(A[right]%2==1){
                right--;
            }

        }
        return A;

    }
}
