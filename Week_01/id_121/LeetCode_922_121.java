class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if(A.length < 2 || A.length > 20000 || A.length % 2 != 0){
            return null;
        }

        int even = 0;
        int odd = 1;
        while(even < A.length && odd < A.length){
            if(!isOdd(A[even]) && isOdd(A[odd])){
                odd = odd + 2;
                even = even + 2;
            }else if(isOdd(A[even]) && !isOdd(A[odd])){
                swap(A,even,odd);
                odd = odd + 2;
                even = even + 2;
            }else if(isOdd(A[odd]) && isOdd(A[even])){
                odd = odd + 2;
            }else if(!isOdd(A[odd]) && !isOdd(A[even])){
                even = even + 2;
            }
        }
        return A;
    }
    public void swap(int[] arr,int head,int tail){
        int tmp = arr[head];
        arr[head] = arr[tail];
        arr[tail] = tmp;
    }
    public boolean isOdd(int a){
        if(a%2 == 1){   //是奇数
            return true;
        }
        return false;
    }
}