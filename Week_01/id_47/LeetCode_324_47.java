/**
 * 交叉放置大小元素
 * 时间复杂度为 O(nlog(n)) -> 排序上面
 */
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        Arrays.sort(nums);
        int[] help = new int[nums.length];
        int len = nums.length;
        int i = (len+1) / 2 - 1;
        int j = len-1;
        int k = 0;
        for (; k < len; ++k) {
            if ((k & 1) == 0) {
                help[k] = nums[i--];
            }
            else {
                help[k] = nums[j--];
            }
        }

        System.arraycopy(help, 0, nums, 0, help.length);
    }
}