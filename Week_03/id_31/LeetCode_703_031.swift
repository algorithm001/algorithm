//
//  LeetCode_703_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/5/4.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class KthLargest {
    var k: Int
    var nums: [Int]
    init(_ k: Int, _ nums: [Int]) {
        self.k = k
        self.nums = nums
        if self.nums.count > 1 { qSort(0, self.nums.count - 1, nums: &self.nums) }
    }
    
    func add(_ val: Int) -> Int {
        if self.nums.isEmpty {
            self.nums.append(val)
        } else {
            insert(val, 0, self.nums.count - 1)
        }
        return find(self.nums.count - self.k, self.nums.count - 1)
    }
    
    // MARK: -- insert
    // 二分查找的思路来插入
    private func insert(_ val: Int, _ from: Int, _ to: Int) {
        let first = self.nums[from]
        let last = self.nums[to]
        if val <= first {
            self.nums.insert(val, at: from)
        } else if val >= last {
            self.nums.insert(val, at: to + 1)
        } else {
            let mid = (from + to)/2
            if val == self.nums[mid] {
                self.nums.insert(val, at: mid)
            } else if val > self.nums[mid] {
                insert(val, mid + 1, to)
            } else {
                insert(val, from, mid - 1)
            }
        }
    }
    
    // MARK: -- find
    private func find(_ from: Int, _ to: Int) -> Int {
        guard from <= to, from >= 0, from <= self.nums.count - 1, to >= 0, to <= self.nums.count - 1 else { return -1 }
        let sortedData = self.nums[from...to]
        guard let first = sortedData.first else { return -1 }
        return first
    }
    
    // MARK: -- sorted
    // 快排
    private func qSort(_ from: Int, _ to: Int, nums: inout [Int]) {
        if (from < to) {
            let part = partition(from, to, nums: &nums)
            qSort(from, part, nums: &nums)
            qSort(part + 1, to, nums: &nums)
        }
    }
    
    // MARK: -- partition
    private func partition(_ from: Int, _ to: Int, nums: inout [Int]) -> Int {
        var from = from
        var to = to
        let indexNumber = nums[from]
        while from < to {
            
            while nums[to] >= indexNumber && to > from {
                to -= 1
            }
            nums[from] = nums[to]
            
            while nums[from] <= indexNumber && to > from {
                from += 1
            }
            nums[to] = nums[from]
        }
        
        nums[from] = indexNumber
        return from
    }
}
