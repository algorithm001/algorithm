class Solution {
public:
  vector<int> sortArrayByParityII(vector<int>& A) {
    if (A.size() == 1) return A;
    int i = 0, j = 1;
    while(j < A.size() && i < A.size() - 1) {
      if (isOdd(A[i]) && isEven(A[j])) {
        swap(A[i], A[j]);
        i += 2;
        j += 2;
      } else if (isEven(A[i])) {
        i += 2;
      } else if (isOdd(A[j])) {
        j += 2;
      }
    }
    return A;
  }
private:
  inline bool isOdd(int value) {
    return value % 2;
  }

  inline bool isEven(int value) {
    return !isOdd(value);
  }
};