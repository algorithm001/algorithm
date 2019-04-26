class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        a, b = [], []
        for val in A:
            if val % 2 == 0:
                a.append(val)
            else:
                b.append(val)
        return a+b