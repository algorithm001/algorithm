class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        i = 0 
        j = len(A) - 1
        while i < j:
            if A[i] % 2 == 1 and A[j] % 2 == 0:
                A[i], A[j] = A[j], A[i]
                i += 1
                j -= 1
            while i < j and A[j] % 2 == 1:
                j -= 1
            while i < j and A[i] % 2 == 0:
                i += 1
        return A

s = Solution()
a = [3, 1, 2, 4]
output = s.sortArrayByParity(a)
print(output)