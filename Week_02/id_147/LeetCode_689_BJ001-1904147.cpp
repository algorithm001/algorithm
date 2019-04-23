#include <iostream>
#include <vector>

class Solution {
public:
    bool canPartitionKSubsets(std::vector<int> &numList, int k) {
        if (k <= 0 || numList.size() < k) {
            return false;
        }
        int sum = 0;
        for (auto i : numList) {
            sum += i;
        }

        if (sum % k != 0) {
            return false;
        }

        std::vector<bool> numStatusList;
        numStatusList.resize(numList.size(), false);

        return partitionKSubsetsInternal(numList, numStatusList, 0, k, sum / k, 0);
    }

private:
    bool partitionKSubsetsInternal(std::vector<int> &numList,
                                   std::vector<bool> &numStatusList,
                                   int start, int k, int avg, int sum) {
        if (k == 0) {
            return true;
        }

        if (sum > avg) {
            return false;
        }

        for (int i = start; i < numList.size(); ++i) {
            if (numStatusList[i]) {
                continue;
            }

            int tmpSum = numList[i] + sum;
            if (tmpSum > avg) {
                continue;
            } else if (tmpSum == avg) {
                numStatusList[i] = true;
                if (partitionKSubsetsInternal(numList, numStatusList, 0, k - 1, avg, 0)) {
                    return true;
                }
                numStatusList[i] = false;
            } else {
                numStatusList[i] = true;
                if (partitionKSubsetsInternal(numList, numStatusList, i + 1, k, avg, tmpSum)) {
                    return true;
                }
                numStatusList[i] = false;
            }
        }
        return false;
    }
};