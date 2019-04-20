class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        int slow = 0, fast = 1;
        
        while((slow < A.size()) && (fast < A.size())) {
            while((slow < A.size()) && (A[slow] % 2 == 0))
                slow += 2;
            while((fast < A.size()) && (A[fast] % 2 == 1))
                fast += 2;
            
            if((slow > A.size()) || (fast > A.size()))
                break;
            int tmp = A[slow];
            A[slow] = A[fast];
            A[fast] = tmp;
            slow += 2;
            fast += 2;
        }
        
        return A;
    }
};