
 //自定义排序方式，单词出现的次数由高到低排序
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
	
	vector<string> topKFrequent_1(vector<string>& words, int k) {

        vector<string> resVec(k);

            map<string,int> hashMap;

            for(auto it = words.begin(); it != words.end(); it++)
            {
                hashMap[*it]++;
            }

            vector<pair<string,int>> pairVec;
            for(auto it = hashMap.begin(); it != hashMap.end();it++)
            {
                pairVec.push_back(std::make_pair(it->first,it->second));
            }

            QuickSort(pairVec,k);
            for(int i = 0; i < k; i++)
            {
                resVec[i] = pairVec[i].first;
            }

            return resVec;
    }
private:
    void QuickSort(vector<pair<string,int> >& pairVec,int k)
    {
        QuickSort_C(pairVec,0,pairVec.size()-1,k);
    }

    void QuickSort_C(vector<pair<string,int> >& pairVec,int s,int t,int k)
    {
        if(s >= t)
            {
                return ;
            }

            int m = Parition(pairVec,s,t);
        
            QuickSort_C(pairVec,s,m-1,k);
           
            QuickSort_C(pairVec,m+1,t,k);
           

    }

    int Parition(vector<pair<string,int> >& pairVec,int s,int t)
    {
       int pivot = t;
            int i = s;  // <
            int j = s;

            for(;j < t;j++)
            {
                pair<string,int> item = pairVec[j];
                if(item.second > pairVec[pivot].second)
                {
                    Swap(pairVec,i,j);
                    i++;
                }else if((item.second == pairVec[pivot].second)
                         && item.first <pairVec[pivot].first)
                {
                    Swap(pairVec,i,j);
                    i++;
                }


            }
            Swap(pairVec,i,pivot);
            return i;
    }

    void Swap(vector<pair<string,int> >& pairVec,int i,int j)
    {
        pair<string,int> tmp = pairVec[i];
        pairVec[i] = pairVec[j];
        pairVec[j] = tmp;
    }
	
	
	
};
