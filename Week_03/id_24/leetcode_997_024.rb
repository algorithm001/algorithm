#解题思路：看到这类问题首先想到了领接表和逆邻接表存储信任关系，根据条件查找是否满足给定的题目条件。
# 处理过程比较简单，实际代码完成过程中还是出现了两个问题，
# 1.忽略了边界条件，信任数组为空且N=1的情况； 
# 2.忘记了反向查找，没有去逆邻接表中查找法官候选人是否信任其他人


# @param {Integer} n
# @param {Integer[][]} trust
# @return {Integer}
def find_judge(n, trust)
   if trust.empty? && n == 1
      return 1 
   end
    trust_hash = {}
    trusted_hash = {}
    trust.each do |trust|
        if trust_hash.has_key? trust[1]
          trust_hash[trust[1]] << trust[0]
        else
          trust_hash[trust[1]] = [trust[0]]
        end
        if trusted_hash.has_key? trust[0]
          trusted_hash[trust[0]] << trust[1]
        else
          trusted_hash[trust[0]] = [trust[1]]
        end
    end
    judge = []
    trust_hash.each do |key, value|
        if value.length == n -1
            judge << key
        end
    end
    judge.delete_if{|a| trusted_hash.has_key? a}
    if judge.length == 1
        return judge.first
    end
    return -1
end
