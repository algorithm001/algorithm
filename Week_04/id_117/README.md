# 学习笔记

### 169
方法一, 直接定义map[int]int来存放数据, 找出出现次数最多的数即可, map的长度为 n/2 + 1, 空间复杂度O(n), 时间复杂度O(n)

方法二, 分治法思想, 摩尔投票法,先假设第一个数过半,并设置count=1,之后遍历剩余数据,如果相同则+1,如果不同则-1; 前提条件是存在元素的个数大于n/2

### 241
方法一,直接for遍历,然后根据运算符来执行判断, 这里的收获是在每一层定义ans来保存当前的原始值或者计算值

方法二,使用动态规划,定义dp为三维数组dp[][][]int

方法三,希望能够将每一个表达式计算出来,但是不知如何保存

### 784
方法一, 使用`map[string]string`存储已经变换的字符串

### 211
方法一，使用暴力破解法，使用`map[int][]string`将长度相同的单词存放在一起，比较简单
方法二，使用`Trie`树（前缀树）

`Trie`树特点：
1.根节点不包含字符，除根节点外的每一个子节点都包含一个字符。
2.从根节点到某一个节点，路径上经过的字符连接起来，为该节点对应的字符串。
3.每个节点的所有子节点包含的字符互不相同。

关键点在于构建和查找
```go
type WordDictionary struct {
    // 使用某一层数据
    children map[rune]*WordDictionary
    isWord bool
}


/** Initialize your data structure here. */
func Constructor() WordDictionary {
    return WordDictionary{children:make(map[rune]*WordDictionary)}
}


/** Adds a word into the data structure. */
func (this *WordDictionary) AddWord(word string)  {
    parent := this
    for _,ch := range word {
        if child,ok:= parent.children[ch];ok {
            parent = child
        } else {
            newChild := &WordDictionary{children:make(map[rune]*WordDictionary)}
            parent.children[ch] = newChild
            // 下一层
            parent = newChild
        }
    }
    parent.isWord = true
}


/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
func (this *WordDictionary) Search(word string) bool {
    parent := this
    for i,ch := range word {
        if rune(ch) == '.' {
            isMatched := false
            for _,v := range parent.children {
                if v.Search(word[i+1:]) {
                    isMatched = true
                }
            }
            return isMatched
        } else if _,ok := parent.children[rune(ch)];!ok  {
            return false
        }
        parent = parent.children[rune(ch)]
    }
    return len(parent.children) ==0 || parent.isWord
}
```
