public class Solution {
    public int MajorityElement(int[] nums) {
            Dictionary<int, int> numCount = new Dictionary<int, int>();
            for(int i=0;i<nums.Length;i++)
            {
                if (numCount.ContainsKey(nums[i]))
                {
                    numCount[nums[i]]++;
                    if(numCount[nums[i]] >=(nums.Length+1)/2)
                    {
                        return nums[i];
                    }
                }
                else
                {
                    numCount[nums[i]] = 1;
                }
            }
            return nums[0];
    }
}
