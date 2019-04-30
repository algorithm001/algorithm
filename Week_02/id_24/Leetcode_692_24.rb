#https://leetcode-cn.com/problems/top-k-frequent-words/
#692. 前K个高频单词

# 解题思路
# 看到单词列表，统计词频，遍历肯定少不了，第一次遍历获取每个单词的出现次数，存储到哈希表中，第二遍遍历
# 哈希表把词频作为key，单词作为值，便于第三步取得前k个单词。
# 需要注意的点，如果出现次数相同需要按照字母序排列，其次最后一步获取的前k个单词的时候，需要一次获取一个判断
# 是否已经达到k个，返回数组。

def top_k_frequent(words, k)
    return [] if words.empty? || k == 0
    hash = {}
    result = []
    order_hash = {}
    words.each do |word|
        if hash.include? word
          hash[word] += 1
        else
          hash[word] = 1
        end
    end
    hash.each do |key, value|
        if order_hash.include? value
          order_hash[value] << key
          order_hash[value].sort!
        else
          order_hash[value] = [key]
        end
    end
    order_hash.keys.sort{|x,y| y <=> x}.each do |value|
        order_hash[value].each do |value|
        result << value
        return result if result.length == k
        end
    end
end
