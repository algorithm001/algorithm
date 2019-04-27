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
#解法二
def is_anagram(s, t)
  x = Array.new(26, 0)
  for i in 0..s.length-1 do
    value = s[i].ord - 97
    x[value] ? x[value] += 1 : x[value] = 0
  end
  for j in 0..t.length-1 do
    value = t[j].ord - 97
    return false if x[value] == 0
    x[value] -= 1
  end
  return true if x.sum == 0
  return false
end

# 解法三
def is_anagram(s, t)
  s_sort = s.split("").sort
  t_sort = t.split("").sort
  s_sort == t_sort
end
