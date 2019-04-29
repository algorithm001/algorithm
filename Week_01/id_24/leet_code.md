### LeetCode
   题目: [83. Remove Duplicates from Sorted List](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)

   解题：

```ruby
# 常规思路
# 注意边界条件
def delete_duplicates(head)
  if head.nil? || head.next.nil?
     return head
  end
  current = head
  while !current.nil? && !current.next.nil? do
    if current.val == current.next.val
      current.next = current.next.next
    else
      current = current.next
    end
  end
  return head
end

# 递归删除
def delete_duplicates(head)
  if head.nil? || head.next.nil?
     return head
  end

  head.next = delete_duplicates(head.next)
  if head.val == head.next.val
     head = head.next
  end
  return head
end
```

### LeetCode
   题目: [242. Valid Anagram](https://leetcode-cn.com/problems/valid-anagram/)

   解题：
   1.常规思路遍历字符串S,存储到哈希表中，遍历字符串t，依次查找哈希表中是否有该字母元素,
   哈希表中元素值为0时，删除该元素，最后判读哈希表是否为空
   2.优化思路，不使用编程语言自己的哈希表，使用自己构建的数组存储字母元素，优化执行效率
   3.看到别人的解法觉得很好，把两个字符串进行排列，比较两个字符串是否相同

```ruby
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
```
