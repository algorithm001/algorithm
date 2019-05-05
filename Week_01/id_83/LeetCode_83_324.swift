//
//  LeetCode324WiggleSort.swift
//  AlgorithmPractice
//
//  Created by Ryeagler on 2019/4/22.
//  Copyright © 2019 Ryeagle. All rights reserved.
//

import Foundation

struct LeetCode324WiggleSort {
    func wiggleSort(_ nums: inout [Int]) {
        guard nums.count >= 2 else {
            return
        }
        
        for i in stride(from: 1, to: nums.count, by: 2) {
            let idx = getLargest(nums, i - 1, i , i + 1)
            (nums[i], nums[idx]) = (nums[idx], nums[i])
        }
    }
    
    private func getLargest(_ nums: [Int], _ x: Int, _ y: Int, _ z: Int) -> Int {
        let len = nums.count
        
        let xVal = x >= 0 && x < len ? nums[x] : Int.min
        let yVal = y >= 0 && y < len ? nums[y] : Int.min
        let zVal = z >= 0 && z < len ? nums[z] : Int.min
        let maxVal = max(xVal, yVal, zVal)
        
        if maxVal == xVal {
            return x
        } else if maxVal == yVal {
            return y
        } else {
            return z
        }
    }
    
    func wiggleSort1(_ nums: inout [Int]) {
        let temp = nums.sorted()
        
        var m = temp.count
        var n = (m + 1) / 2
        
        for i in 0..<nums.count {
            if i & 1 == 0 {
                n = n - 1
                nums[i] = temp[n]
            } else {
                m = m - 1
                nums[i] = temp[m]
            }
        }
    }
    

}
