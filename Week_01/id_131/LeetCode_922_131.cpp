class Solution {
public:
    int findSuitData(vector<int>& unorderV, int index) 
    {
        if (unorderV.empty())
        {
            unorderV.push_back(index);
            return -1;
        }
        int lastIndex = unorderV[unorderV.size() - 1];
        if (index % 2 != lastIndex % 2)
        {
            unorderV.pop_back();
            return lastIndex;
        }
        else
        {
            unorderV.push_back(index);
        }
        return -1;
    }
    
    vector<int> sortArrayByParityII(vector<int>& A) {
        vector<int> unorderV;
        for (int begin = 0; begin < A.size(); ++begin)
        {
            if (begin % 2 != A[begin] % 2)
            {
                int i = findSuitData(unorderV, begin);
                if (i >= 0)
                {
                    int tmpData = A[begin];
                    A[begin] = A[i];
                    A[i] = tmpData;
                }
            }
        }
        return A;
    }

};