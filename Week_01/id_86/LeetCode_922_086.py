class Solution:
    def sortArrayByParityII(self, A):
        e, o = [a for a in A if not a % 2], [a for a in A if a % 2]
        return [e.pop() if not i % 2 else o.pop() for i in range(len(A))]
