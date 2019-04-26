


    // 偶数个元素                 奇数个元素
    // [1, 6, 1, 5, 1, 4]        [2, 6, 1, 5, 1]
    //  小 大 小 大  小 大         小 大 小 大 小
    // 要符合上面的格式，需要对素组进行排序，然后分成大、小两部分
    // 元素是奇数个时，小的那部分要多一个元素
    public void wiggleSort(int[] nums) {
        int len = nums.length;

        if (len == 0){
            return;
        }
        // 数组排序
        int[] rst = Arrays.copyOf(nums, len);
        Arrays.sort(rst);
        for (int i = 0; i < len; i++) {
            nums[i] = 0;
        }

        // 取大数部分的起始位置
        int big = 0;
        if (len % 2 == 0){
            big = len / 2;
        }else {
            big = len / 2 + 1;
            nums[len-1] = rst[0];
        }
        // 每次分别从大、小两部分取一个数写入
        // [4,5,5,6] 分别从两部分的前面开始取数，不能满足这种情况，所以从后往前取数
        for (int i = 0; i < len - big; i++) {
            nums[i*2] = rst[big - 1 - i];
            nums[i*2+1] = rst[len -1 - i];
        }