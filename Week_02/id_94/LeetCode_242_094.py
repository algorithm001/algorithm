class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False

        s_list = [0] * 26
        t_list = [0] * 26
        for x in s:
            s_list[ord(x) - 97] += 1
        for y in t:
            t_list[ord(y) - 97] += 1
        return s_list == t_list