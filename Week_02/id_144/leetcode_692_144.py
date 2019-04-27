from collections import Counter
class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        d = {}
        for word in words:
            if word not in d:
                d[word] = 0
            d[word] += 1
        res =  sorted(d.items(),key=lambda item:item[0],reverse=False)
        return [v[0] for v in sorted(res,key=lambda item:item[1],reverse=True)[:k]]
            
        
        