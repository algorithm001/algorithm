# 第二周总结-LeetCode236 做题简记与资源分享


本周只做了两道题目，主要是被 236 题给难住了，参考了 discuss 中的答案才想清楚，这里整理一波该题的做题思路吧。

```Java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //  1. 递归终止条件：到达叶节点或者目标节点
        if(root == null || root == p || root == q) {
            return root;
        }  


        // 2. 递归公式：当前节点是否为 p、q 两个节点的祖先节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 3. 基于递归结果求解
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}
```

题目要求是求 p、q 节点的最近的祖先节点，这里有两种情况

- 1. p、q 有共同的祖先节点，那么返回结果就是最低的祖先节点

![](https://github.com/zouyingjie/arts/blob/master/image/algorithm01.png)

- 2. 一个节点为另一个节点的祖先节点，那么返回的就是 p、q 中的那个祖先节点

![](https://github.com/zouyingjie/arts/blob/master/image/algorithm03.png)


对于树相关的题目，一个很重要的做题原则就是：

> 只关注一个节点

回到 第 236 题，如果确定一个节点是否为 p、q 两个节点的祖先节点，判断依据就是

- 其左右子树中包含两个节点

那么我们要做的就是查看其左子树、右子树是否包含 p、q 两个节点。同样对于左右子节点，依然是采用相同的逻辑判断，这里完全符合递归的求解方式：大问题拆分为逻辑相同的子问题。代码如下：

```
TreeNode left = lowestCommonAncestor(root.left, p, q);
TreeNode right = lowestCommonAncestor(root.right, p, q);
```
对于一个节点计算完成后，我们得到了其左右子树包含 p、q 节点的结果，此时再基于上面提到的两种情况进行结果返回

***拥有共同祖先节点***

该种其结果一定是左右子树都可能查找到对应的节点，因此只要某个节点的查找结果满足

>  left != null && right !=null 

就说明该节点就是 p、q 的共同祖先节点。

***一个节点为另一个节点的祖先节点***

此时，计算的结果会如图所示：

![](https://github.com/zouyingjie/arts/blob/master/image/algorithms04.png)

x 为 y 的节点父节点， x 的父节点在计算时，left 为空，right 则返回了 x 节点自身。因此对于这种情况，当 left 或 right 有一个为 null 一个不为 null 时，
不为 null 的节点即为共同祖先节点。


采用递归的解法，最快的情况下每个节点都要遍历一遍，时间复杂度为 O(N)，空间上只有节点的空间占用，因此空间复杂度也为 O(N)。

严格来说并不是一道很难做的题目，但是自己在做题时动不动就想复杂了，虽然捋清楚了两种情况，但是在实现递归代码时没想明白，重要的还是要聚焦于一个节点上，对于树相关的题目解析，一般都是一个个节点上的重复逻辑计算，只要把一个节点上的逻辑搞明白，就可以采用递归的方式求解了，递归方面还是很薄弱，需要进一步加强练习。

***资源分享***

#### 1.Youtube 的两个频道

- [Vivekanand Khyade - Algorithm Every Day](https://www.youtube.com/channel/UCx-kFfzekMbhODaBss-ZnsA)：一位印度小哥的算法讲解视频，口音有浓重的咖喱味，但理解起来也不算很难，耐心的多听几遍基本可以听懂，既可以学算法，也可以练听力。
- [Back To Back SWE](https://www.youtube.com/channel/UCmJz2DV1a3yfgrR7GqRtUUA)：这是做第 236 题时搜到了这个频道的讲解视频，发音更标准一些，本次题目思路的整理主要是参考了频道里面的一个讲解视频。

#### 2. 《算法》配套课程

皓叔在专栏中也推荐过 [算法](https://book.douban.com/subject/10432347/)这本书，其实本书的作者 Robert Sedgewick 还针对书籍出了一个配套课程发布在了 [Coursera](https://www.coursera.org/) 上。

- [Algorithms-Part1](https://www.coursera.org/learn/algorithms-part1)：第一部分介绍了并查集、栈、队列、链表、排序等基础算法
- [Algorithms-Part2](https://www.coursera.org/learn/algorithms-part2)：第二部分相对较难，介绍了图、最短路径、字符串相关的算法。

看书的同学有兴趣的话可以参照课程进行辅助学习。