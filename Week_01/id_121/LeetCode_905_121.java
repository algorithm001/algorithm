class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A == null || A.length < 1 || A.length > 5000){
            return null;
        }
        int head = 0;
        int tail = A.length - 1;
        while(head >=0 && tail>= 0 && head < A.length && tail < A.length && head < tail){
            if(!isOdd(A[head]) && isOdd(A[tail])){
                head ++;
                tail --;
            }else if(isOdd(A[head]) && !isOdd(A[tail])){
                swap(A,head,tail);
                head ++;
                tail --;
            }else if(isOdd(A[head]) && isOdd(A[tail])){
                tail --;
            }else if(!isOdd(A[head]) && !isOdd(A[tail])){
                head ++;
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