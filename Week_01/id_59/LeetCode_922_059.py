class Solution:
    def sortArrayByParityII(self, A: List[int]) -> List[int]:
        even = 1
        for odd in range(0, len(A), 2):
            if A[odd] % 2:
                while A[even] % 2:
                    even += 2
                A[odd], A[even] = A[even], A[odd]
        return A