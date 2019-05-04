class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        trustNum = [0] * N    #信任别人的数目
        trustedNum = [0] * N    #被别人信任的数目
        for a, b in trust:
            trustNum[a-1] += 1
            trustedNum[b-1] += 1
        for i in range(N):
            if trustNum[i] == 0 and trustedNum == N-1:
                return i+1
        return -1