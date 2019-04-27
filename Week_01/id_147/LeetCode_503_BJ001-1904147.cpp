#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int> &nums) {
        vector<int> result;
        auto n = nums.size();
        result.resize(n, -1);
        std::stack<int> stack;
        for (int i = 0; i < 2 * n; ++i) {
            int index = i % n;
            auto num = nums[index];
            if (stack.empty()) {
                stack.push(num);
                continue;
            }
            while (!stack.empty() && nums[stack.top()] < num) {
                result[stack.top()] = num;
                stack.pop();
            }
            stack.push(index);
        }

        return result;
    }
};

int main(int argc, char **argv) {
    vector<int> nums;
    nums.emplace_back(1);
    nums.emplace_back(2);
    nums.emplace_back(1);
    Solution solution;
    auto result = solution.nextGreaterElements(nums);
    for (auto i:result) {
        std::cout << i << std::endl;
    }

    return 0;
}