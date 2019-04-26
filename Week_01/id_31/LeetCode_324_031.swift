//
//  LeetCode_324_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/19.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func wiggleSort(_ nums: inout [Int]) {
        qSort(0, nums.count - 1, &nums)
        createWiggle(&nums)
    }
    
    private func createWiggle(_ nums: inout [Int], _ fromLeft: Bool = true) {
        var data: [Int] = []
        var from = 0
        var to = nums.count - 1
        var mid = (from + to) / 2
        if fromLeft {
            for _ in from...mid {
                if (from < nums.count) {
                    if data.count > 0, let last = data.last, nums[from] >= last {
                        return createWiggle(&nums, false)
                    }
                    data.append(nums[from])
                    from += 1
                }
                if (mid + 1 < nums.count) {
                    if data.count > 0, let last = data.last, nums[mid+1] <= last {
                        return createWiggle(&nums, false)
                    }
                    data.append(nums[mid + 1])
                    mid += 1
                }
            }
        } else {
            let mIndex = mid
            for _ in mid...to {
                if (mid >= 0) {
                    data.append(nums[mid])
                    mid -= 1
                }
                if (to > mIndex) {
                    data.append(nums[to])
                    to -= 1
                }
            }
        }
        nums = data
    }
    
    private func qSort(_ from: Int, _ to: Int, _ nums: inout [Int]) {
        if from < to {
            let mid = findPartition(from, to, &nums)
            qSort(from, mid - 1, &nums)
            qSort(mid + 1, to, &nums)
        }
    }
    
    private func findPartition(_ from: Int, _ to: Int, _ nums: inout [Int]) -> Int {
        let indexNumber = nums[from]
        var from = from
        var to = to
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
