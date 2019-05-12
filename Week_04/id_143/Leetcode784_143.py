

##解法1 用DFS的做法 类似八皇后用回溯的思想 取或者不取
class Solution:
    def letterCasePermutation(self, S: str) -> List[str]:

        res =list()
        l =len(S)
        if l==0:
            return [""]
        def dfs(start,temp):
            if start >= l or len(temp) == l:
                res.append(temp)
                return
            if S[start].isdigit():
                dfs(start + 1, temp + S[start])

            elif S[start].islower():
                dfs(start + 1, temp + S[start])
                dfs(start + 1, temp + S[start].upper())

            elif S[start].isupper():
                dfs(start + 1, temp + S[start])
                dfs(start + 1, temp + S[start].lower())
        dfs(0,"")
        return res


##BFS的做法  就是每一个序号index遍历 把每一种index下的情况考虑好 才进入下一个index
class Solution(object):
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        import copy
        res = [""]

        for i, x in enumerate(S):
            # if len(res) == 0:
            #     res.append(x)
            if x.isdigit():#数字就每个答案都加进去
                for index, item in enumerate(res):
                    res[index] += (x)
            elif x.isupper():#字母就每个答案先放自己再放对立面
                temp = list()
                for index, item in enumerate(res):
                    # print item
                    temp.append(item + (x))
                    temp.append(item + (x.lower()))
                res = copy.deepcopy(temp[:])
            elif x.islower():
                temp = list()
                for index, item in enumerate(res):
                    temp.append(item + (x))
                    temp.append(item + (x.upper()))
                res = copy.deepcopy(temp[:])
            # print temp
        return res