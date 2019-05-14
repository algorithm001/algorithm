class Solution:
    # 暴力方法破解，暴力遍历每个字符串前缀是不是都在数组中，在比较是不是最长的、如果等长看是不是字母序更小
    # 开始没用set，直接用words List结果超时，果然差别很大，Set居然是O(1)
    def longestWord(self, words):
        wordSet = set(words)
        theWord = ""
        for w in words:
            print(w)
            isIn = True
            for i in range(1, len(w)):
                if w[:i] not in wordSet:
                    print("%s is not in " % w[:i])
                    isIn = False
                    break
            if isIn:
                if not theWord or len(theWord) < len(w):
                    theWord = w
                elif len(w) == len(theWord) and theWord > w:
                    theWord = w
        return theWord

    def longestWord2(self, words):
        words.sort()  # sort成树状结构
        res = set([''])  # 建立一个空的set 直接去重了
        longestWord = ''
        for word in words:
            print(word)
            if word[:-1] in res:  # 判断每个单词的除去最后一个字母是否在set里
                res.add(word)
                print(res)
                if len(word) > len(longestWord):
                    longestWord = word  # 保存最长的词
        return longestWord


words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
demo = Solution()
print("result: %s" % demo.longestWord(words))
