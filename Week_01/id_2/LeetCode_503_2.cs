using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace leetcode
{
    public class 下一个更大元素_II
    {
        public int[] NextGreaterElements(int[] nums)
        {
            int[] result = new int[nums.Length];
            for (int i = 0; i < nums.Length; i++)
            {
                result[i] = -1;
                for (int j = 1; j < nums.Length; j++)
                {
                    var index = (i + j) % nums.Length;
                    if (nums[index] > nums[i])
                    {
                        result[i] = nums[index];
                        break;
                    }
                }
            }

            return result;
        }
    }
}
