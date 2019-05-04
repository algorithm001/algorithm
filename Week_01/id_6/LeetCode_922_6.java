
// 新建数组，偶数插入偶位置，奇数插入奇位置
// 两个指针分别指向偶、奇位置
public int[] sortArrayByParityII(int[] A) {
    int[] B = new int[A.length];

    int odd = 1;
    int even = 0;

    for (int i = 0; i < A.length ; i++) {
        if (A[i] % 2 == 0){
            B[even] = A[i];
            even += 2;
        }else {
            B[odd] = A[i];
            odd += 2;
        }
    }

    return B;
}