//
//  LeetCode_33_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/18.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    var temp: [Int: Int] = [:]
    func search(_ nums: [Int], _ target: Int) -> Int {
        var nums = nums
        if (nums.isEmpty) { return -1 }
        for i in 0...nums.count - 1 { temp[nums[i]] = i }
        qSort(0, nums.count - 1, &nums)
        return binaryFind(nums, target, 0, nums.count - 1)
    }
    
    private func binaryFind(_ nums: [Int], _ target: Int, _ from: Int, _ to: Int) -> Int {
        if (from > to) { return -1 }
        var from = from
        var to = to
        let mid = (from + to) / 2
        if nums[mid] == target {
            if let v = temp[nums[mid]] { return v }
            return -1
        } else if nums[mid] > target {
            to = mid - 1
            return binaryFind(nums, target, from, to)
        } else {
            from = mid + 1
            return binaryFind(nums, target, from, to)
        }
    }
    
    private func qSort(_ from: Int, _ to: Int, _ nums: inout [Int]) {
        if from < to {
            let findPartition = partition(from, to, &nums)
            qSort(from, findPartition - 1, &nums)
            qSort(findPartition + 1, to, &nums)
        }
    }
    
    
    private func partition(_ from: Int, _ to: Int, _ nums: inout [Int]) -> Int {
        let indexNumber = nums[from]
        var i = from
        var j = to
        while i < j {
            while nums[j] >= indexNumber && i < j {
                j -= 1
            }
            nums[i] = nums[j]
            
            while nums[i] <= indexNumber && i < j {
                i += 1
            }
            nums[j] = nums[i]
        }
        nums[i] = indexNumber
        return i
    }
}
