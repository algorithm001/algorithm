#  学习笔记

## 二分查找

### 第一次写的没写对的
```ruby
def binary_search(array = [], term)
  low = 0
  high = array.length
  mid = (low + high)/2.ceil

  if term > array[mid] # term偏大
    low = mid + 1
  elsif term < array[mid] # term 偏小
    high = mid -1
  elsif term == array[mid]
    return mid
  else
    return "数组中没有此元素"
  end
end
```

### 考虑边界条件后写对的
```ruby
# 二分法
def binary_search(array, term)
  low = 0
  high = array.length - 1

  loop do
    mid = (low + high)/2.ceil

    if term > array[mid] # term偏大
      low = mid + 1
    end
    if term < array[mid] # term偏小
      high = mid - 1
    end

    # 循环结束条件
    # 1. 找到 term， 跳出循环
    # 2. 数组遍历完了，跳出循环

    if term == array[mid]
      return mid
    end
    if low > high
      return "数组中没有此元素"
    end
  end
end

### 测试
```ruby
a = [1,2,3,4,5],
b = [3, 6, 9, 29, 38, 42]
binary_search(a, 2)
# `=> 1`
binary_search(b, 29)
# `=> 3`
binary_search(b, 22)
# `=> "数组中没有此元素"`
```

你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
给定一个数字 n，找出可形成完整阶梯行的总行数。
n 是一个非负整数，并且在32位有符号整型的范围内。

审题：n 是一个非负整数，并且在32位有符号整型的范围内。 得出 n <= 2^31 即2147483648

分析：什么时候返回k？  边界条件
条件1： (1+k）/2 * k = n
条件2： (1+k）/2 * k > n && [1 + (k-1)]/2 * (k-1) < n
k的值 从(1..n)  里面一个一个试， 直到找到符合条件1和2的 k值，并返回。
继续分析：k的值 从(1..n)  里面一个一个试太麻烦，(1..n)是一个数组，可以试试用二分法。

```ruby
def binary_coin(n)

  array = (1..n).to_a  # 范围转换数组花费时间比较长

  low = 0
  high = array.length - 1

  loop do
    mid = (low+ high)/2.ceil
    k = array[mid]
    if (1+ k) * k / 2 == n                      # 边界条件1
      return @result = k
    elsif (1+ k) * k / 2 > n && k * (k-1)/2 < n # 边界条件2
      return @result = k - 1
    elsif(1+ k) * k / 2 > n                    # mid偏大
      high = mid - 1
    else                                        # mid偏小
      low =  mid + 1
    end
  end
end

(1..10).to_a.each do |x|
  puts binary_coin(x)
end
puts 'binary_coin(100000000)'
puts binary_coin(100000000)
```

## 我理解的练习的过程是纠正思维的过程
>刚开始做这个算法的时候，我看见这个题目是关于在二分查找的题。所以我就在想怎么使用二分查找，二分查找有什么特点，反正就是使劲往二分查找上面套，看了半天越来越发现，这他么哪里是二分查找，倒有点像递归。
反正连想带画了几十分钟没弄出来，还跑了点歪路，去想用数学怎么去解。
我发觉这种思维方式有问题

拿到一个算法，第一步思考的不应该是去套什么公式，而是向正常思维一样。先用几个很简单的例子来看看这个算法的过程。
然后我再一步一步解决。在演化的过程中，我觉得把数据一个一个带进去试很烦，而这个正是计算机擅长的事情。


### 有一个新的思路，二分法可以试试递归，因为每次操作都是和中间的数进行比较
