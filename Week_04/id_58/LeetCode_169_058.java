package algorithm.Week_04.id_58;

/**
 * 169. Majority Element
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * 分析：
 * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
 *
 * @auther: guangjun.ma 
 * @date: 2019/5/12 23:12
 * @version: 1.0
 */
public class LeetCode_169_058 {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(count == 0) {
                majority = nums[i];
            }
            if(nums[i] == majority){
                count++;
            }else{
                count--;
            }
        }
        return majority;
    }
}
