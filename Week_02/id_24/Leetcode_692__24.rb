
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
