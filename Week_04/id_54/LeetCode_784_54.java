class Solution(object):
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        res = list()
        l = len(S)
        if l == 0:
            return [""]
            
        def dfs(start, temp):
            if start >= l or len(temp) == l: #已经找到了一个答案
                res.append(temp)
                return
            # print start, temp
            if S[start].isdigit(): #数字就直接加
                dfs(start + 1, temp + S[start])
            
            elif S[start].islower(): #字母就加本身和对立面
                dfs(start + 1, temp + S[start])
                dfs(start + 1, temp + S[start].upper())

            elif S[start].isupper():
                dfs(start + 1, temp + S[start])
                dfs(start + 1, temp + S[start].lower())
        
        dfs(0, "")
        return res
