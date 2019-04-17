# @param {String} s
# @param {String} t
# @return {Boolean}

# 解法一
def is_anagram(s, t)
    source_hash = {}
    s.each_char { |s|
      if source_hash[s]
        source_hash[s] += 1
      else
        source_hash[s] = 1
      end
    }
	t.each_char { |t|
		return false unless source_hash.keys.include? t
		source_hash[t] -= 1
		source_hash.delete_if {|_, value| value == 0 }
	}
	return true if source_hash.empty?
	return false
end
