class Solution:
    def reverse(self, x: int) -> int:
        if x == 0:
            return 0
        s = str(x)
        x = ""
        if s[0] == "-":
            x += "-"
        x += s[len(s)-1::-1].lstrip("0").rstrip("-")
        x = int(x)
        if -2**31 < x < 2**31-1:
            return x
        return 0