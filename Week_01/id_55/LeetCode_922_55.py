class Solution:
    def sortArrayByParityII(self, A):
        a, b = [], []
        for val in A:
            if val % 2 == 0:
                a.append(val)
            else:
                b.append(val)
        c, d = 0, 0
        for c in A:
            A[c] = a[d]
            A[c+1] = a[d]
            c += 1
            d += 2

        return a+b