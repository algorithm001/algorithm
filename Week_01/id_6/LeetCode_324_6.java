


    // ż����Ԫ��                 ������Ԫ��
    // [1, 6, 1, 5, 1, 4]        [2, 6, 1, 5, 1]
    //  С �� С ��  С ��         С �� С �� С
    // Ҫ��������ĸ�ʽ����Ҫ�������������Ȼ��ֳɴ�С������
    // Ԫ����������ʱ��С���ǲ���Ҫ��һ��Ԫ��
    public void wiggleSort(int[] nums) {
        int len = nums.length;

        if (len == 0){
            return;
        }
        // ��������
        int[] rst = Arrays.copyOf(nums, len);
        Arrays.sort(rst);
        for (int i = 0; i < len; i++) {
            nums[i] = 0;
        }

        // ȡ�������ֵ���ʼλ��
        int big = 0;
        if (len % 2 == 0){
            big = len / 2;
        }else {
            big = len / 2 + 1;
            nums[len-1] = rst[0];
        }
        // ÿ�ηֱ�Ӵ�С������ȡһ����д��
        // [4,5,5,6] �ֱ�������ֵ�ǰ�濪ʼȡ������������������������ԴӺ���ǰȡ��
        for (int i = 0; i < len - big; i++) {
            nums[i*2] = rst[big - 1 - i];
            nums[i*2+1] = rst[len -1 - i];
        }