//
// Created by Administrator on 2019/4/22.
//
using namespace std;

#include <vector>
#include <map>
#include <string>
class Solution {
public:
    //#692 给一非空的单词列表，返回前 k 个出现次数最多的单词。
    //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
    //思考：这里先用map表存次数，然后排序，取最后三个数即可
    //这里要注意排序的时候要优先按大小，然后按字符顺序
    vector<string> topKFrequent(vector<string>& words, int k) {
        if (k > words.size()) return words;
        map<string, int> temp;
        vector<string> res;
        for (string i : words) {
            temp[i]++;
        }
        vector<pair<string, int>> tVector(temp.begin(), temp.end());
        sort(tVector.begin(), tVector.end(), cmp);
        int i = tVector.size() - 1;
        while (k > 0) {
            res.push_back(tVector[i].first);
            i--;
            k--;
        }
        return res;
    }
    //排序方法
    static bool cmp(const pair<string, int>& a, const pair<string, int>& b) {
        if (a.second == b.second) {
            return a.first > b.first;
        };
        return a.second < b.second;
    }
};