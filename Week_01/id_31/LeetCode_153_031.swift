//
//  LeetCode_153_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/15.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

// 时间复杂度 O(n)
class Solution {
    func findMin(_ nums: [Int]) -> Int {
        guard nums.count > 0 else { return -1 }
        if var result = nums.first {
            _ = nums.map { result = min(result, $0) }
            return result
        }
        return -1
    }
}
