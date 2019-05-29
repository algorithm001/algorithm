import java.util.Arrays;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/04
 */
public class LeetCode_698_108 {
    //这道题没调出来，看的别人的答案
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            //因为题目限制条件不用担心溢出
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum += nums[i];
            }
            if(sum % k != 0){
                return false;
            }
            //求出子集的和
            sum = sum / k;
            //排序 小的放最前面大的放最后面
            Arrays.sort(nums);
            //如果子集的和小于数组最大的直接返回false
            if(nums[nums.length - 1] > sum){
                return false;
            }
            //建立一个长度为k的桶
            int[] arr = new int[k];
            //桶的每一个值都是子集的和
            Arrays.fill(arr, sum);
            //从数组最后一个数开始进行递归
            return help(nums, nums.length - 1, arr, k);
        }

        boolean help(int[] nums, int cur, int[] arr, int k){
            //已经遍历到了-1说明前面的所有数都正好可以放入桶里，那所有桶的值此时都为0，说明找到了结果，返回true
            if(cur < 0){
                return true;
            }
            //遍历k个桶
            for(int i = 0; i < k; i++){
                //如果正好能放下当前的数或者放下当前的数后，还有机会继续放前面的数（剪枝）
                if(arr[i] == nums[cur] || (cur > 0 && arr[i] - nums[cur] >= nums[0])){
                    //放当前的数到桶i里
                    arr[i] -= nums[cur];
                    //开始放下一个数
                    if(help(nums, cur - 1, arr, k)){
                        return true;
                    }
                    //这个数不该放在桶i中
                    //从桶中拿回当前的数
                    arr[i] += nums[cur];
                }
            }
            return false;
        }

    }
}
