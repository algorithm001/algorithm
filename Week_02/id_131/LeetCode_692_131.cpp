/* ��Ŀ���� :
 * ǰK����Ƶ����
 * ��һ�ǿյĵ����б�����ǰ k �����ִ������ĵ��ʡ�
 * ���صĴ�Ӧ�ð����ʳ���Ƶ���ɸߵ������������ͬ�ĵ�������ͬ����Ƶ�ʣ�����ĸ˳������
*/
class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        // ����map
        map<string, int> numMap;
        // ͳ���ַ������ִ���
        for(auto& word : words) ++numMap[word];
        
        // multimapĬ�ϼ�ֵΪ�������У����������������multimap<int, string, greater<int>>
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