//
// Created by 贾凯超 on 2019/4/15.
//

#ifndef TASKS_WEEK_1_H
#define TASKS_WEEK_1_H

#endif //TASKS_WEEK_1_H

using namespace std;

#include <map>
#include <vector>
#include <stack>
#include <math.h>

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class WeekOneSolution {
public:
    //链表部分
    ListNode *deleteDuplicates(ListNode *head);

    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2);

    ListNode *swapPairs(ListNode *head);

    ListNode *detectCycle(ListNode *head);

    ListNode *reverseKGroup(ListNode *head, int k);

    //数组部分
    vector<int> sortArrayByParity(vector<int> &A);

    vector<int> sortArrayByParityII(vector<int> &A);

    bool search(vector<int> &nums, int target);

    int findMin(vector<int> &nums);

    int search1(vector<int> &nums, int target);

    //栈部分
    bool isValid(string s);

    vector<int> nextGreaterElements(vector<int> &nums);

    //递归部分
    int longestUnivaluePath(TreeNode *root);

    int rTree(TreeNode *root, int val, int &result);

    bool canPartitionKSubsets(vector<int> &nums, int k);

    bool rSubSum(vector<int> &nums, vector<int> &temp, int subSum);

    //排序
    bool isAnagram(string s, string t);
    void wiggleSort(vector<int> nums);
    int maximumGap(vector<int>& nums);

    //二分查找
    int arrangeCoins(int n);
    double myPow(double x, int n);
    int calculateMinimumHP(vector<vector<int>> dungeon);
};

//#83 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//链表题，边界问题
//思考：利用hashMap记录,使用数组（如果只存储0/1状态，可以使用位存储）
//采坑：开始想使用一维数组存储，测试用例中有-1，所以只能使用map
ListNode *WeekOneSolution::deleteDuplicates(ListNode *head) {
    map<int, int> temp;
    ListNode *current = head;
    ListNode *pre = head;
    while (current) {
        //如果存在重复数据
        if (temp[current->val]) {
            if (current->next) {
                pre->next = current->next;
            } else {
                //边界问题处理
                pre->next = NULL;
            }
        } else {
            temp[current->val] = 1;
            pre = current;
        }
        if (!current->next) {
            break;
        }
        current = current->next;
    }
    return head;
}

//#21 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有结点组成的。
//思考：合并两个有序链表，这里采用归并逻辑将两个链表按序写入新链表中。需要注意当一个链表为空时另一个链表的处理
ListNode *WeekOneSolution::mergeTwoLists(ListNode *l1, ListNode *l2) {
    ListNode *p = l1;
    ListNode *q = l2;
    ListNode *t = new ListNode(-1);
    ListNode *head = t;
    //合并
    while (p && q) {
        if (p->val < q->val) {
            t->next = p;
            p = p->next ? p->next : NULL;
        } else {
            t->next = q;
            q = q->next ? q->next : NULL;
        }
        t = t->next;
    }
    //如果有一个链表处理完，将剩下的链表直接链到最后
    if (q) {
        t->next = q;
    }
    if (p) {
        t->next = p;
    }
    return head->next;
}

//#24 给定一个链表，两两交换其中相邻的结点，并返回交换后的链表。
//思考：结点互相交换，可以使用两个指针分移动，然后交换。但是需要考虑奇数结点的问题
ListNode *WeekOneSolution::swapPairs(ListNode *head) {
    //如果是空链表或者单个链表直接返回
    if (!head || !head->next) return head;
    ListNode *first = head;
    ListNode *second = head->next;
    ListNode *pre = NULL;
    ListNode *result = second;
    while (first && second) {
        //交换结点，如果第二个结点后面无结点直接为NULL
        first->next = second->next ? second->next : NULL;
        second->next = first;
        if (pre) {
            pre->next = second;
        }
        //已经完成置换,或者还剩余一个结点不需要置换
        if (!first->next || !first->next->next) {
            break;
        }
        //移动指针
        pre = first;
        first = first->next;
        second = first->next;
    }
    return result;
}

//#142 给定一个链表，返回链表开始入环的第一个结点。 如果链表无环，则返回 null。
//思考：使用hashMap存放走过的记录，但会增加额外空间
//进阶：在不破坏原链表也不使用额外空间的情况下，使用快慢指针方案。但是由于可能不是一个完整的环
//会导致时间效率降低很多
ListNode *WeekOneSolution::detectCycle(ListNode *head) {
    map < ListNode * , int > temp;
    ListNode *current = head;
    while (current) {
        //如果存在，说明曾经走过，第一次出现的即是第一个结点
        if (temp[current]) {
            return current;
        }
        temp[current] = 1;
        current = current->next ? current->next : NULL;
    }
    return NULL;
}

//#25 给出一个链表，每 k 个结点一组进行翻转，并返回翻转后的链表。
//思考：分段反转采用双指针实现，本身思路并不复杂。但是不小心会被指针指晕
ListNode *WeekOneSolution::reverseKGroup(ListNode *head, int k) {
    int size = 1;
    ListNode *first = NULL;
    ListNode *last = NULL;
    ListNode *pre = NULL;
    ListNode *current = head;
    //遍历链表，查找反转结点并反转
    while (current) {
        if (size == 1) {
            first = current;
        } else if (size == k) {
            last = current;
        }
        size++;
        //用于current的后移，再反转过程中current->next会被修改
        ListNode *tCurrent = current->next ? current->next : NULL;
        //链表反转，这里建议重写一个新方法增加可读性
        if (first && last) {
            ListNode *t = first;
            ListNode *p = first;
            ListNode *tt;
            ListNode *tp;
            while (t) {
                tt = t->next ? t->next : NULL;
                tp = t == first ? first : t;
                if (t != first) {
                    t->next = p;
                }
                if (t == last) {
                    if (pre) {
                        pre->next = t;
                    } else {
                        head = t;
                    }
                    break;
                }
                p = tp;
                t = tt;
            }
            first->next = tCurrent;
            //完成链表反转，重置状态
            pre = first;
            first = last = NULL;
            size = 1;
        }
        current = tCurrent;
    }
    return head;
}

//#905 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
//思考：使用双指针，分别从前后遍历，然后互相交换
vector<int> WeekOneSolution::sortArrayByParity(vector<int> &A) {
    int left = 0;
    int right = A.size() - 1;
    while (left != right) {
        if (A[left] % 2 == 0) {
            left++;
            continue;
        }
        if (A[right] % 2 == 1) {
            right--;
            continue;
        }
        swap(A[left], A[right]);
    }
    return A;
}

//#922 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//思考：简单思路新建一个数组存放即可
vector<int> WeekOneSolution::sortArrayByParityII(vector<int> &A) {
    vector<int> result(A.size());
    int odd = 1;
    int even = 0;
    for (int i : A) {
        if (i % 2 == 0) {
            result[even] = i;
            even += 2;
        }
        if (i % 2 == 1) {
            result[odd] = i;
            odd += 2;
        }
    }
    return result;
}

//#81 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
//编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
//思考：有序数组查找，直接二分
bool WeekOneSolution::search(vector<int> &nums, int target) {
    if (nums.size() == 0) {
        return false;
    }
    vector<int> l;
    vector<int> r;
    if (nums[0] == target) {
        return true;
    }
    for (int i = 1; i < nums.size(); i++) {
        if (nums[i] > nums[0]) {
            r.push_back(nums[i]);
        }
        if (nums[i] < nums[0]) {
            l.push_back(nums[i]);
        }
    }
    if (target > nums[0]) {
        return search(r, target);
    }
    if (target < nums[0]) {
        return search(l, target);
    }
    return false;
}

//#153 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//请找出其中最小的元素。
//思考：找到旋转点，因为是升序数组旋转 最小的数一定在旋转点，或者数组最开始
int WeekOneSolution::findMin(vector<int> &nums) {
    int rotatePoint = INT_MAX;
    if (nums.size() == 1) {
        return nums[0];
    }
    if (nums.size() <= 0) {
        return NULL;
    }
    for (int i = 1; i < nums.size(); i++) {
        if ((nums[i] - nums[i - 1]) < 0) {
            rotatePoint = nums[i];
        }
    }
    return min(rotatePoint, nums[0]);
}

//#33 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//你可以假设数组中不存在重复的元素。
//你的算法时间复杂度必须是 O(log n) 级别。
//思考：这个题目跟#81很像，思路应该也差不多，所以偷个懒快速解决
int WeekOneSolution::search1(vector<int> &nums, int target) {
    for (int i = 0; i < nums.size(); i++) {
        if (target == nums[i]) {
            return i;
        }
    }
    return -1;
}

//#20 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//有效字符串需满足：
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。
//思考：栈的应用，要注意最后判断栈是否为空
bool WeekOneSolution::isValid(string s) {
    if (s.size() == 0) {
        return true;
    }
    stack<char> temp;
    for (char c : s) {
        if (c == ')' || c == ']' || c == '}') {
            if (temp.empty()) return false;
            char top = temp.top();
            switch (c) {
                case '}':
                    if (top != '{') return false;
                    break;
                case ']':
                    if (top != '[') return false;
                    break;
                case ')':
                    if (top != '(') return false;
                    break;
            }
            temp.pop();
        } else if (c == '(' || c == '[' || c == '{') {
            temp.push(c);
        }
    }
    if (!temp.empty()) return false;
    return true;
}

//#503 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
//输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
//这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
//思考：该算法时间复杂度为O(n^2)，需要优化，另外没有用到stack，使用取模的方式控制循环
vector<int> WeekOneSolution::nextGreaterElements(vector<int> &nums) {
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

//[?]#687 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
//思考：父节点跟子节点相同时最大长度要+1
int WeekOneSolution::longestUnivaluePath(TreeNode *root) {
    if (!root) return 0;
    int result = 0;
    rTree(root, root->val, result);
    return result;
}

int WeekOneSolution::rTree(TreeNode *root, int val, int &result) {
    if (!root) return 0;
    //左子树最长路径
    int left = rTree(root->left, root->val, result);
    //右子树最长路径
    int right = rTree(root->right, root->val, result);
    result = max(result, left + right);
    if (root->val == val)
        return max(left, right) + 1;
    return 0;
}

//[?] #698 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
//思考：解决方案有问题，后续再研究
bool WeekOneSolution::canPartitionKSubsets(vector<int> &nums, int k) {
    int sum = 0;
    for (int i : nums) {
        sum += i;
    }
    if (sum % k != 0) return false;
    int subSum = sum / k;
    sort(nums.begin(), nums.end());
    if (nums.back() > subSum) return false;
    while (nums.size() && (nums.back() == subSum)) {
        nums.pop_back();
        k -= 1;
    }
    vector<int> temp(k, 0);
    return rSubSum(nums, temp, subSum);
}

bool WeekOneSolution::rSubSum(vector<int> &nums, vector<int> &temp, int subSum) {
    if (!nums.size()) return true;
    int v = nums.back();
    nums.pop_back();

    for (vector<int>::iterator i = temp.begin(); i != temp.end(); i++) {
        if (v + *i <= subSum) {
            *i += v;
            if (rSubSum(nums, temp, subSum)) return true;
            *i -= v;
        }

        if (*i == 0) break;
    }

    return false;
}

//#242 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
//思考：异位词排序后应该完全相同
bool WeekOneSolution::isAnagram(string s, string t) {
    sort(s.begin(), s.end());
    sort(t.begin(), t.end());
    return s == t;
}

//#324 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
//思考：该题难点在于如何将数组调整到大小穿插排列。方案：先排序，然后分成两部分。将数据按顺序写入临时数组
void WeekOneSolution::wiggleSort(vector<int> nums) {
    if (nums.size() <= 1) {
        return;
    }
    vector<int> temp(nums.size());
    sort(nums.begin(), nums.end());
    //数组分为两部分，第一部分是0到i; 第二部分是i 到j - 1
    int i = (nums.size() + 1) / 2;
    int j = nums.size();
    for (int m = 0; m < temp.size(); m++) {
        if (m % 2 == 1) {
            temp[m] = nums[--j];
        } else {
            temp[m] = nums[--i];
        }
    }
    nums = temp;
}

//#164 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
//如果数组元素个数小于 2，则返回 0。
//思考：难点在于线性条件下的排序。可以考虑用空间换时间，桶排序？
int WeekOneSolution::maximumGap(vector<int> &nums) {
    if (nums.size() < 2) return 0;
    sort(nums.begin(), nums.end());
    int value = 0;
    for (int i = 1; i < nums.size(); i++) {
        int temp = nums[i] - nums[i - 1];
        value = max(temp, value);
    }
    return value;
}

//#441 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
//给定一个数字 n，找出可形成完整阶梯行的总行数。
//n 是一个非负整数，并且在32位有符号整型的范围内。
int WeekOneSolution::arrangeCoins(int n) {
    int l = 1;
    while (n > 0) {
        n = n - l;
        if (n >= 0) l++;
    }
    return l - 1;
}

//#50 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//思考：解法一为简单相乘，但是会有重复计算，所以可以采用分治。
//解法二：采用递归实现分治，但是时间效率还是低，所以改用循环二分，也就是解法三
//采坑：一开始使用abs()求绝对值，但是用例中的范围超出了限制
double WeekOneSolution::myPow(double x, int n) {
//解法一：直接乘
//    double result = 1;
//    for (int i = 0; i < abs(n); i++) {
//        result *= x;
//    }
//    return n >= 0 ? result : 1 / result;
//===========================================
//解法二：二分递归
//    if (n == 1) return x;
//    if (n == -1) return 1 / x;
//    if (n == 0) return 1;
//    double result = 0;
//    if (abs(n) % 2 == 0) {
//        result = myPow(x, abs(n / 2)) * myPow(x, abs(n / 2));
//    } else {
//        result = myPow(x, abs(n / 2)) * myPow(x, abs(n / 2)) * x;
//    }
//    return n > 0 ? result : 1 /result;
//解法三：二分非递归
    double result = 1;
    int i = n;
    while (i != 0) {
        if (i % 2 != 0) {
            result *= x;
        }
        x *= x;
        i /= 2;
    }
    return n > 0 ? result : 1 / result;
//解法四：直接使用库函数
//    return pow(x, n);
}

//#174 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
//思考：可用DFS算法，计算出所有的解。
//又相当于子区域的最低点数的子问题，使用动态规划解决
//重要的事说三遍：先画递归树！先画递归树！先画递归树！
//该方案超出时间限制需要优化时间复杂度
int WeekOneSolution::calculateMinimumHP(vector<vector<int>> dungeon) {
    //条件判断
    int m = dungeon.size();
    int n = dungeon[0].size();
    if (dungeon.empty()) return 0;
    if (m == 1 && n == 1) {
        return max(1 - dungeon[0][0], 1);
    }
    //数组分片
    vector<vector<int>> down(m -1, vector<int>(n, 0));
    vector<vector<int>> right(m, vector<int>(n - 1, 0));
    int healthPoint = dungeon[0][0];
    if (m > 1) {
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                down[i - 1][j] = dungeon[i][j];
            }
        }
    }
    if (n > 1) {
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                right[i][j - 1] = dungeon[i][j];
            }
        }
    } else {
        right.clear();
    }
    int health = 0;
    //判断递归，解决子问题
    if (!right.empty() && down.empty()) {
        health = calculateMinimumHP(right) - healthPoint;
        healthPoint = health <= 0 ? 1 : health;
    }
    if (!down.empty() && right.empty()) {
        health = calculateMinimumHP(down) - healthPoint;
        healthPoint = health <= 0 ? 1 : health;
    }
    if (!right.empty() && !down.empty()) {
        health = min(calculateMinimumHP(down), calculateMinimumHP(right)) - healthPoint;
        healthPoint = health <= 0 ? 1 : health;
    }
    return healthPoint;
}





