package geekcode

/*
https://leetcode-cn.com/problems/single-number/

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4


因为抑或满足交换律，所以， 乱序 也可以随意交换，
把两个相同的放在一起，抑或为 0 ,
最后剩下多余的那个数字，就是出现一次的数字
*/

func singleNumber(nums []int) int {
	num := 0
	for _, v := range nums {
		num = num ^ v
	}
	return num
}

/***
func singleNumber(nums []int) int {
    hashnums := make(map[int]int)
    for k,v := range nums {
        if  _,ok := hashnums[v] ; ok {
            delete(hashnums,v)
        }else {
            hashnums[v] = k
        }
    }
    for idx,_ := range(hashnums) {
        return idx
    }
    return -1
}
**/
