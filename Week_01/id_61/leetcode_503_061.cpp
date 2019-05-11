//
// Created by 贾凯超 on 2019/4/18.
//
//#503 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
//输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
//这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
//思考：该算法时间复杂度为O(n^2)，需要优化，另外没有用到stack，使用取模的方式控制循环
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> result(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            int j = (i + 1) % nums.size();
            result[i] = -1;
            while (i != j) {
                if (nums[j] > nums[i]) {
                    result[i] = nums[j];
                    break;
                }
                j = (j + 1) % nums.size();
            }
        }
        return result;
    }
};