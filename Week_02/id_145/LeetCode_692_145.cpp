struct intComp {
	bool operator() (const pair<int, string>& lhs, const pair<int, string>& rhs) const{
		return lhs.first > rhs.first;
	}
};
class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        vector<string> resVec(k);//存储结果
		map<string, int> hashMap;
        //用于统计各个单词出现的次数，并按照字母顺序排序
		for (auto word : words) {
			hashMap[word] += 1;
		}
        //然后按照单词出现的次数进行排序
		multiset<pair<int, string>, intComp> mySet;
		for (auto &item : hashMap) {
			mySet.insert({ item.second, item.first });
		}
        //取出前k个
		multiset<pair<int, string>>::iterator it = mySet.begin();
		for (int i = 0; i < k; ++i, ++it) {
			resVec[i] = it->second;
		}
		return resVec;
    }
};