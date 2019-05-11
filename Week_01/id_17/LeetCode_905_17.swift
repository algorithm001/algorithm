class Solution {
	func sortArrayByParity(_ A: [Int]) -> [Int] {
		var even = [Int]()
		var odd = [Int]()

        for number in A {
            if number % 2 == 0 {
				even.append(number)
			} else {
				odd.append(number)
			}
        }
			
		return even+odd
	}
}

// 使用注释中的 forEach 代码的运行时间是 92 ms
// 而使用 for in 的运行时间只有 72 ms
// Runtime: 72 ms, faster than 93.41% of Swift online submissions for Sort Array By Parity.
// Memory Usage: 19.4 MB, less than 12.50% of Swift online submissions for Sort Array By Parity.
