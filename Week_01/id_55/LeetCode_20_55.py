class Solution:
    def isValid(self, s: str) -> bool:
        a = {')': '(', ']': '[', '}': '{'}
        l = [None]
        # 遍历s
        for i in s:
            print(l)
            # 判断如果i在a中并且比如说是}，那么如果i是否等于{(前部分也就是字典的key) 如果是就pop，如果不是就写入l
            if i in a and a[i] == l[-1]:
                l.pop()
            else:
                l.append(i)
        return len(l) == 1