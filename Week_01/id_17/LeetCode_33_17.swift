class Solution {
    func search(_ nums: [Int], _ target: Int) -> Int {
        if nums.count == 0 { return -1 }
        let breakPoint = find_breakPoint(nums)
        return binary_search(nums, target, offset: breakPoint)
    }

    func find_breakPoint(_ numbers: [Int]) -> Int {
        for (index, number) in numbers.enumerated() {
            if number < numbers[0] { return index }
        }
        return 0
    }

    func binary_search(_ numbers: [Int], _ target: Int, offset: Int) -> Int {
        if numbers.count == 0 { return -1 }
        var low = 0
        var high = numbers.count - 1

        while low <= high {
            let middle = (low + high)/2
            let index = realIndex(middle, count: numbers.count, offset: offset)
            let number = numbers[index]
            if number == target {
                return index
            } else if number < target {
                low = middle + 1
            } else {
                high = middle - 1
            }
        }

        return -1
    }

    func realIndex(_ index: Int, count: Int, offset: Int) -> Int {
        if index < count-offset {
            return index+offset
        } else {
            return index+offset-count
        }
    }
}

// Runtime: 20 ms, faster than 100.00% of Swift online submissions for Search in Rotated Sorted Array.
// Memory Usage: 19 MB, less than 33.33% of Swift online submissions for Search in Rotated Sorted Array.
