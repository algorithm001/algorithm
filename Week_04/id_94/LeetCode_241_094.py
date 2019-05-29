from typing import List


class Solution(object):
    def diffWaysToCompute(self, input: str) -> List[int]:

        list = []
        for i in range(len(input)):
            c = input[i]
            if c == "+" or c =="-" or c =="*" or c=="/":

                left = self.diffWaysToCompute(input[:i])
                right = self.diffWaysToCompute(input[i+1:])

                for le in left:
                    for ri in right:
                        if c == "+":
                            list.append(int(le)+int(ri))
                        elif c == "-":
                            list.append(int(le)-int(ri))
                        elif c == "*" :
                            list.append(int(le)*int(ri))
                        elif c == "/":
                            list.append(int(le) / int(ri))

        if len(list)==0:
            list.append(int(input))
        return list



if __name__=="__main__":
    result = Solution().diffWaysToCompute("11/2")
    print(result)