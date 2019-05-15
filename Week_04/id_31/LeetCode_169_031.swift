//
//  LeetCode_169_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/5/12.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

// 哈希Map
class Solution {
    func majorityElement(_ nums: [Int]) -> Int {
        guard !nums.isEmpty else { return -1 }
        var res: [Int: Int] = [:]
        for v in nums {
            if var data = res[v] {
                data += 1
                res[v] = data
            } else {
                res[v] = 1
            }
            if res[v]! > nums.count / 2 { return v }
        }
        return -1
    }
}

// 排序
class Solution {
    func majorityElement(_ nums: [Int]) -> Int {
        guard !nums.isEmpty else { return -1 }
        let sorted = nums.sorted{ $0 < $1 }
        return sorted[(0+sorted.count - 1) / 2]
    }
}

// 分治算法
class Solution {
    func majorityElement(_ nums: [Int]) -> Int {
        return major(nums, 0, nums.count - 1).value
    }
    
    private func major(_ nums: [Int], _ from: Int, _ to: Int) -> (value: Int, count: Int) {
        guard from < to else { return (value: nums[from], 1)}
        let mid = from + (to - from) / 2
        let leftData = major(nums, from, mid)
        let rightData = major(nums, mid+1, to)
        if leftData.value == rightData.value {
            return (value: leftData.value, count: leftData.count + rightData.count)
        }
        
        
        if (leftData.count > rightData.count) {
            return (value: leftData.value, count: leftData.count + findNum(leftData.value, Array(nums[mid+1...to])))
        } else {
            return (value: rightData.value, count: rightData.count + findNum(rightData.value, Array(nums[from...mid])))
        }
    }
    
    private func findNum(_ value: Int, _ nums: [Int]) -> Int {
        var res: Int = 0
        _ = nums.map { if ($0 == value) { res += 1 }}
        return res
    }
}
