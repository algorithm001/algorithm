class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        low, high = 0, len(A) - 1
        while low < high:
            if A[low] % 2 > A[high] % 2:
                A[low], A[high] = A[high], A[low]
            
            if A[low] % 2 == 0:
                low += 1
            
            if A[high] % 2 == 1: 
                high -= 1
            
        return A