class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& A) {
        int begin = 0, end = A.size()-1;
        while(begin < end)
        {
            if(A[begin]%2 == 0) ++begin;
            if(A[end]%2 == 1) --end;
            if(begin >= end) break;
            if((A[begin]%2 == 1) && (A[end]%2 == 0))
            {
                A[begin] ^= A[end];
                A[end] ^= A[begin];
                A[begin] ^= A[end];
                ++begin;
                --end;
            }  
        }
        return A;
    }
};