class Solution {
    public int majorityElement(int[] nums) {
         // 初始放入第一个元素并开始计数
        int maj = nums[0];
        int count = 1;
        // 第二个元素开始比较
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }
}
