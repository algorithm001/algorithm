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
    #puts judge, trust_hash
    judge.delete_if{|a| trusted_hash.has_key? a}
   # puts judge,1
    if judge.length == 1
        return judge.first
    end
    return -1
end
