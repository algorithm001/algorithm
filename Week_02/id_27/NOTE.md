# 学习笔记
第二周题目
哈希表
简单：https://leetcode-cn.com/problems/valid-anagram/            --finish
中等：https://leetcode-cn.com/problems/top-k-frequent-words      --finish
中等：https://leetcode-cn.com/problems/find-duplicate-file-in-system/    --finish
困难：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
困难：https://leetcode-cn.com/problems/number-of-atoms/

二叉树
简单：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/     --finish
中等：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/  --finish
中等：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
困难：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
困难：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/

二叉搜索树
简单：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/     --finish
中等：https://leetcode-cn.com/problems/range-sum-of-bst/
中等：https://leetcode-cn.com/problems/contains-duplicate-iii/
困难：https://leetcode-cn.com/problems/count-of-range-sum/
困难：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/

# 题目203的结题过程
- 未添加虚拟头结点
- 添加虚拟头结点
- 递归解法
真实的感受到代码一步步的简化过程

# 单调栈
1. https://leetcode-cn.com/problems/daily-temperatures/

样例解析：
73入栈，74>73，73出栈，74入栈，74使得73出栈，所以73需要等待1-0=1天 ，栈内元素74.
75入栈，75>74, 74出栈，75入栈，75使得74出栈，所以74需要等待2-1=1天，栈内元素75.
71入栈，71<75，直接入栈，栈内元素 75,71
69直接入栈，栈内元素75,71,69
72入栈，72>69,69出栈，72使69出栈，所以69需要等待5-4=1天，此时栈内元素75,71，由与72>71,任不满足单调栈性质，71出栈，72使71出栈，所以71需要等待5-3=2天，站内元素75,75>72,72直接入栈，栈内元素为：75,72.
以此类推。。。

2. https://leetcode-cn.com/problems/next-greater-element-i/
3. https://leetcode-cn.com/problems/next-greater-element-ii/

下面这两个题一个解法，暂时没发现4和上面三个题的联系
4. https://leetcode-cn.com/problems/next-greater-element-iii/
5. https://leetcode-cn.com/problems/next-permutation/

如果从第n个数字到最后都是递减的并且第n-1个数字小于第n个，说明从第n个数字开始的这段序列是字典序组合的最后一个，在下一个组合中他们要倒序变为字典序第一个，然后从这段序列中找出第一个大于第n-1个数字的数和第n-1个数字交换就可以了。

举个栗子，当前组合为12431，可以看出431是递减的，同时4>2，这样我们把431倒序，组合就变为12134，然后从134中找出第一个大于2的数字和2交换，这样就得到了下一个组合13124。对于完全递减的组合例如4321在倒序之后就可以结束了。
原文：https://blog.csdn.net/fuxuemingzhu/article/details/82113731
