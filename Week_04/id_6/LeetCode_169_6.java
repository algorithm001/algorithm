

    // LeetCode 169



    // 此次 从n/2分开，分别统计数字出现次数
    // 多种数字的话，可以用散列表<num, 次数>保存
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n <= 2){
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (i = 0; i < n; i++) {
            if (map.containsKey(nums[i])){
                int m = map.get(nums[i]) + 1;
                if (m > n/2){
                    break;
                }
                map.put(nums[i], m);
            }else {
                map.put(nums[i], 1);
            }
        }

        return nums[i];
    }