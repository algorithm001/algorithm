1，建立新数组

//执行用时 : 6 ms, 在Sort Array By Parity II的Java提交中击败了83.69% 的用户
//内存消耗 : 48.9 MB, 在Sort Array By Parity II的Java提交中击败了67.91% 的用户

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if(A == null || A.length == 1) return A;
        int k = A.length-1;
        int[] B = new int[A.length];
        
        int i = 0;
        int j = 0;
        int x = 1;
        while(i<=k){
           if(A[i]%2 == 0){
                B[j] = A[i];
                j=j+2;
            }
            else{
                B[x] = A[i];
                x = x+2;
            }
            i++;
        }
        return B;
    }
}



2，
//执行用时 : 7 ms, 在Sort Array By Parity II的Java提交中击败了77.23% 的用户
//内存消耗 : 49.7 MB, 在Sort Array By Parity II的Java提交中击败了51.80% 的用户

//执行用时 : 5 ms, 在Sort Array By Parity II的Java提交中击败了93.39% 的用户
//内存消耗 : 41.5 MB, 在Sort Array By Parity II的Java提交中击败了92.67% 的用户

//执行用时 : 7 ms, 在Sort Array By Parity II的Java提交中击败了77.23% 的用户
//内存消耗 : 52.3 MB, 在Sort Array By Parity II的Java提交中击败了9.49% 的用户
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if(A == null || A.length == 1) return A;
        int k = A.length-1;
        
        int i = 0;
        int j = 1;
        
        while(i<=k && j<=k){
            if(A[i]%2 != 0 && A[j]%2 == 0 ){
                int temp = A[i];
                A[i] = A[j];
                A[j]=temp;
                i = i+2;
                j = j+2;
            }
            else{
                if(A[i]%2==0) i = i+2;
                if(A[j]%2!=0) j = j+2;
            }
        }
        return A;
    }
}