class Solution {
public:
  vector<int> sortArrayByParity(vector<int>& A) {
    int i = 0, j = A.size() - 1;
    while (i < j) {
      if (isOdd(A[i]) && isEven(A[j])) {
        swap(A[i], A[j]);
        i++;
        j--;
      } else if (isEven(A[i])) {
        i++;
      } else if (isOdd(A[j])) {
        j--;
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