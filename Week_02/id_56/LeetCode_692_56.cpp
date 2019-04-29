vector<string> topKFrequent(vector<string>& words, int k) {
        //1.[] 2.find insert 3.insert
        map<string,int> countmap; 
        //将字符串按照字母顺序排序，并统计出字符串出现的次数                
        for(auto& e : words)
            countmap[e]++;
        
        multimap<int,string,greater<int>> sortmap;//出现次数为key，字符串为value
        //按照出现次数从大到小进行排序
        for(const auto& kv:countmap)
        {
            sortmap.insert(make_pair(kv.second,kv.first));
        }
        
        vector<string> v;
        multimap<int,string>::iterator it = sortmap.begin();
        while(it != sortmap.end() && k--)
        //遍历排好序的map取出前k个出现频率最高的字符串放入vector中
        {
            v.push_back(it->second);
            ++it;
        }        
        return v;  
    }
