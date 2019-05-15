

	// 怎么用二分法没想通 ？？ 


	public int arrangeCoins(int n) {
        if (n == 0){
            return 0;
        }

        // 循环分解，直到剩余数量 < 分解次数+1
        int i = 0;
        for (i = 1; i < n; i++) {
            n -= i;
            if (n < i + 1){
                break;
            }
        }

        return i;
    }