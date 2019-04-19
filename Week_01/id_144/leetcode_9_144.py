class Solution:
    def isPalindrome(self, x: int) -> bool:
        s = str(x)
        l = len(s)
        mid = int(len(s)/2)
        for i in range(mid):
            if s[i] != s[l-1-i]:
                return False
                break
        return True
            