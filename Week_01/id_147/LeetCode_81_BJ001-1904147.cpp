#include <iostream>
#include <vector>

class Solution {
public:
    bool search(std::vector<int> &nums, int target) {
        if (nums.empty()) {
            return false;
        }
        size_t length = nums.size();
        if (length == 1) {
            return nums[0] == target;
        }
        size_t left = 0;
        size_t right = length - 1;

        while (left < right) {
            if (nums[left] == target) {
                return true;
            }
            if (nums[right] == target) {
                return true;
            }
            size_t mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                return true;
            }

            if (mid == right || mid == left) {
                return false;
            }

            if (nums[left] <= nums[right]) {
                if (nums[left] > target || nums[right] < target) {
                    return false;
                }
                if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
                continue;
            } else {
                if (nums[mid] < target) {
                    if (nums[right] > target) {
                        left = mid;
                    } else {
                        if (nums[mid] < nums[right]) {
                            right = mid;
                        }else{
                            left = mid;
                        }
                    }
                } else {
                    if (nums[right] > target) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
                continue;
            }
        }

        return nums[left] == target;
    }
};