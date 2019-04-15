package geekcode

/*
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
