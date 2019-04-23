//
//  LeetCode_164_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/19.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func maximumGap(_ nums: [Int]) -> Int {
        guard nums.count > 0 else { return 0 }
        var nums = nums
        qSort(&nums, 0, nums.count - 1)
        var maxSpace = 0
        for i in 0...nums.count - 1 {
            if (nums.count > i + 1) {
                maxSpace = max(maxSpace, nums[i+1] - nums[i])
            }
        }
        return maxSpace
    }
    
    private func qSort(_ nums: inout [Int], _ from: Int, _ to:Int) {
        if from < to {
            let mid = findPartition(&nums, from, to)
            qSort(&nums, from, mid)
            qSort(&nums, mid + 1, to)
        }
    }
    
    private func findPartition(_ nums: inout [Int], _ from: Int, _ to: Int) -> Int {
        var from = from
        var to  = to
        let indexNumber = nums[from]
        while from < to {
            while nums[to] >= indexNumber && from < to {
                to -= 1
            }
            nums[from] = nums[to]
            while nums[from] <= indexNumber && from < to {
                from += 1
            }
            nums[to] = nums[from]
        }
        nums[from] = indexNumber
        return from
    }
}
