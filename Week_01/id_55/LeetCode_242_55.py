class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        s_array, t_array = [0]*26, [0]*26
        for letter in s:
            s_array[ord(letter)-97] += 1
        for letter in t:
            t_array[ord(letter)-97] += 1
        return s_array == t_array


s = "anagram"
t = "nagaram"
# 实例化
demo = Solution()
print(demo.isAnagram(s, t))