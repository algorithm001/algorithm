#include <iostream>

using namespace std;

class Solution {
public:
    int arrangeCoins(int n) {
        int sum = n;
        for (int i = 1; i <= n; ++i) {
            sum -= i;

            if (sum == 0) {
                return i;
            }

            if (sum < 0) {
                return i - 1;
            }
        }
    }
};

int main(int argc, char **argv) {
    Solution solution;
    std::cout << solution.arrangeCoins(50) << std::endl;
    std::cout << solution.arrangeCoins(8) << std::endl;
    return 0;
}