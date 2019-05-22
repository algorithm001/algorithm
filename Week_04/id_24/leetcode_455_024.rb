[455. 分发饼干](https://leetcode-cn.com/problems/assign-cookies/submissions/)

###解题思路：看到这个题首先想到的就是贪心算法，贪心算法实现上需要注意两个问题，
###1. 饼干的大小和孩子的期望需要排序
###2. 需要及时跳过已经分配的饼干，不允许饼干的多次分配

def find_content_children(g, s)
    i = 0
    j = 0
    child = 0
    s = s.sort
    g = g.sort
   
    while i < s.length && j < g.length
        if s[i] >= g[j]
            i+=1
            j+=1
            child += 1
        else
            i+=1
        end
    end
    return child
end
