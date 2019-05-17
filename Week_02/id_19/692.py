class Solution(object):
    def topKFrequent(self,words:List[str],k:int):
        d = {w:0 for w in words}
        for w in words:
            d[w] += 1
            l = list(d.items())
            l.sort(key=lambda x:(-x[1],x[0]))
            ans = []
            for i in range(k):
                ans += l[i][0]
                return ans
