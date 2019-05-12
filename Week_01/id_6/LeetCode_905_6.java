
    // 新建数组，偶数从前往后存入，奇数从后往前存入
	// 时间复杂度O(n)
	// 空间复杂度O(2n)，但这样不破坏原有数组
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];

        int head = 0;
        int tail = A.length -1;
        // 遍历数据，检查奇偶性
        for (int i = 0; i < A.length ; i++) {
            if (A[i] % 2 == 0){
                B[head] = A[i];
                head ++;
            }else {
                B[tail] = A[i];
                tail --;
            }
            // 所有数据都遍历完
            if (head > tail){
                break;
            }
        }
        return B;
    }


    // 两个指针分别从前后扫描，偶数从前往后存入，奇数从后往前存入
	// 避免新增数组，节约内存空间
	// 时间复杂度O(n)
	// 空间复杂度O(n)，但破坏原有数组
    public int[] sortArrayByParity1(int[] A) {
        if (A.length == 1){
            return A;
        }

        int head = 0;
        int tail = A.length -1;
        int swap = 0;
        // 遍历数据，检查奇偶性
        for (int i = 0; i < A.length ; i++) {
            // head指向偶数，前进
            if (A[head] % 2 == 0){
                head ++;
            }
            // head指向奇数，查找尾部最后一个偶数，和head交换
            else {
                if (A[tail] % 2 != 0){
                    tail --;
                }else {
                    swap = A[head];
                    A[head] = A[tail];
                    A[tail] = swap;
                    head ++;
                    tail --;
                }

            }
            // 所有数据都遍历完
            if (head >= tail){
                break;
            }
        }
        return A;
    }