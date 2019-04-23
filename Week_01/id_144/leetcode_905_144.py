class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        s1 = []
        s2 = []
        for a in A:
            if a %2 == 0:
                s1.append(a)
            else:
                s2.append(a)
        return s1 + s2
        