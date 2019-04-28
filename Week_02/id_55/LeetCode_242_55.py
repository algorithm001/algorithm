# 上周有个相同题目用数组但是没法处理unicode，换成字典就可以了
    def isAnagramUnicode(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        alpha = {}
        beta = {}
        for c in s:
            alpha[c] = alpha.get(c, 0) + 1
        for c in t:
            beta[c] = beta.get(c, 0) + 1
        return alpha == beta