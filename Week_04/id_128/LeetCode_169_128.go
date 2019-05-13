func majorityElement(nums []int) int {
    m := make(map[int]int)
    for i := 0; i < len(nums); i++ {
        num := nums[i]
        m[num] = m[num] + 1
        if m[num] > len(nums)/2{
            return num
        }
    }
    return 0
}
