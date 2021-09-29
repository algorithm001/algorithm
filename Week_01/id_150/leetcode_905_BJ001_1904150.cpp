class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& A) {
        int left = 0, right = A.size() - 1;
        while(left < right) {
            while(left < A.size() && (A[left] % 2 == 0)) left++;
            while(right >= 0 && (A[right] % 2)) right--;
            
            if(left >= right)
                break;
            
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
            left++;
            right--;
        }
        
        return A;
    }
};