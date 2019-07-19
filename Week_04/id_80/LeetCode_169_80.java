class Solution {
    //摩尔投票法
    //假设数组非空、总是存在众数。
    public static int majorityElement(int[] nums)
      {
          int count=0;//计算当前的数字出现的次数
          int mj=0;//当前判断的元素
          for (int i = 0; i < nums.length; i++)
          {
             if(count==0){//当次数为0时，则换下一判断元素
                 mj=nums[i];
                 count=1;
             }
             else if (nums[i]==mj) {
                 count++;//当前元素等于判断元素，次数加1
             }
             else {
                 count--;//不等于则次数减一
             }
         }
          return mj;
      }
 }
