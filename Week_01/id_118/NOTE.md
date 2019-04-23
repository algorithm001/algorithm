# 本周学习重点

由于时间有限，本周学习重点放在 链表和数组 这两类题型上。

一些比较有收获的点是：
1. 同一类型的题目，可以从 easy 开始做，然后到 middle 最后再到 hard，层层递进，因为难题都是由简单题目演进而来的，由浅入深会比较容易接受，
2. 做题前，先对“已知信息”做收集，然后再看利用已有知识，如何达到题目要求。
3. 解题思路可以靠画图辅助梳理，解法也可以在纸上走一遍进行推导，不要上来就写代码。
4. 最后，同一题可以尝试用不同的方法去解决。


# 链表题型总结
本周截止写这篇总结时，做完的链表题目有：
- [leetcode.83.删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)
- [leetcode.21.合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
- [leetcode.24.两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)
- [leetcode.142.环形链表2](https://leetcode-cn.com/problems/linked-list-cycle-ii/)
- [leetcode.25.k个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

一些小总结：
- 链表题型，怎么都跑不了一些基本操作：插入节点（头、尾、中间），删除节点（头、尾、中间），相邻节点交换。所以，必须对这些操作熟悉的不能再熟悉。
- 链表题型，比较常见的是：
    - 删除指定条件的元素（eg：删除重复元素、删除倒数第k个节点、删除中间节点或a/b处的节点）
    - 链表反转（eg：整体反转、两两反转、k个一组反转）
    - 环的问题（eg：判断链表中是否有环、找到链表环的第一个节点）
    - 两个链表的问题（eg：两个有序链表合并、求两个有序链表的公共部分）
    - 。。。。。。
- 链表问题的解法：
    - 常规题，一般是辅助指针，加上常规的插入删除交换操作就可以搞定。
    - 部分题型需要结合哈希表。
    - 有一些题目需要用些小技巧，比如多次迭代、快慢指针等。
- 写代码时需要注意的点：
    - 注意不要丢节点，有一些操作的前后顺序很重要，一不小心就把后面的整条链给丢掉了。
    - 也不要造成环，链表拆解或合并，最容易出现这种情况，一定要在纸上把流程捋清晰了再写代码。
    - 有时候，加一个哨兵节点能够简化操作。


# 数组题型总结
本周截止到写这篇总结时，做完的链表题目有：
- [leetcode.905.按奇偶排序数组](https://leetcode-cn.com/problems/sort-array-by-parity/)
- [leetcpde.922.按奇偶排序数组2](https://leetcode-cn.com/problems/sort-array-by-parity-ii/)
- [leetcode.153.寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/submissions/)
- [leetcode.33.搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/)
- [leetcode.704.二分查找](https://leetcode-cn.com/problems/binary-search/)

一些小总结：
- 数组题型相比链表就比较杂了，我做过的题目也不是太多，以我浅薄的经验稍稍总结一下。
- 数组的特点基本操作，一般是：数据移动交换或删除。不一般是：排序、二分、以及其他图算法等等。
- 我目前做的这几道题，基本上都是排序和二分查找。几个关键点吧：
    - 排序题目要么是冒泡、插入、归并等这些经典的算法题，要么是这些算法题的变种。其中以归并、快排的思路居多，也偶尔有一些插入排序的变形题。
    - 查找类题目，只要要求了 O(logn)，基本上就二分没跑了，实现上可能能用递归解决。
- 写代码时：
    - 首先要注意数组越界问题。
    - 接下来是需要用到的索引指针的初始化的问题。
    - 以及，非常琐碎的边界点的问题，比如 是 > 还是 >=，是 left=middle 还是 left = middle+1。



