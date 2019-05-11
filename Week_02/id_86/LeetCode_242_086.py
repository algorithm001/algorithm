class Solution(object):
    def isAnagram(self, s, t):
        dic1 = {}
        dic2 = {}
        for t in s:
            dic1[t] = dic1.get(t,0)+1
        for t in t:
            dic2[t] = dic2.get(t,0)+1
        return dic1 == dic2

    def isAnagram2(self, s, t):
        return sorted(s) == sorted(t)
