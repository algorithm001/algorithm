class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        A = [0] * 26
        if len(t) != len(s):
            return False
        for i in range(len(s)):
            A[ord(s[i])-ord('a')] += 1
        for i in range(len(t)):
            A[ord(t[i])-ord('a')] -= 1
        for i in range(26):
            if A[i] != 0:
                return False
        return True

s = "anagram"
t = "nagaram"

solution = Solution()
print(solution.isAnagram(s, t))


