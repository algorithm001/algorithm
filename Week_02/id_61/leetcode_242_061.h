//
// Created by Administrator on 2019/4/15.
//

#ifndef TASKS_MAIN_H
#define TASKS_WEEK_1_H
using namespace std;

class Solution {
public:
//#242 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
//思考：这里放弃之前先排序的思路，使用静态数组；整体思路是s串有一次就+1，t有一次就-1
//如果有不为0的就一定不一样
    bool isAnagram(string s, string t) {
        int a[26] = {0};
        for (int i : s) {
            //a的ascii码97
            a[i - 97]++;
        }
        for (int i : t) {
            a[i - 97]--;
        }
        for (int i : a) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
};
#endif //TASKS_MAIN_H
