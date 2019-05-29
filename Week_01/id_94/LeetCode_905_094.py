class Solution(object):
    def sortArrayByParity(self, A):
        left = 0
        right = len(A)-1
        middle = int((right+left)/2)
        print ("中间值",middle)
        while(left<right):

            if (A[left]%2) == 0:
                left += 1
            elif (A[left]%2) != 0 :

                tmp = A[right]
                A[right] = A[left]
                A[left] = tmp

                right = right - 1
                # left = left + 1
        return A



if __name__=="__main__":
    A = [1,0,3]
    array = Solution()
    print (array.sortArrayByParity(A))






