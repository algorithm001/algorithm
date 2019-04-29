/* 题目描述 :
 * 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
*/
class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        // 有序map
        map<string, int> numMap;
        // 统计字符串出现次数
        for(auto& word : words) ++numMap[word];
        
        // multimap默认键值为升序排列，如果按降序排列则multimap<int, string, greater<int>>
        multimap<int, string, greater<int>> sortMap;
        for(const auto& kv : numMap)
        {
            sortMap.insert(make_pair(kv.second, kv.first));
        }
        
        vector<string> strKTopVec;
        multimap<int, string>::iterator iter = sortMap.begin();
        while(iter != sortMap.end() && k--)
        {
            strKTopVec.push_back(iter->second);
            ++iter;
        }
        return strKTopVec;
    }
};