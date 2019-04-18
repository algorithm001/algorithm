//
//  LeetCode_905_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/15.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

// 时间复杂度 O(n)
// 方法 1
class Solution {
    func sortArrayByParity(_ A: [Int]) -> [Int] {
        guard A.count > 0 else { return [] }
        var tempA = A
        var i = 0
        var j = tempA.count - 1
        while i <= j {
            if (tempA[i] % 2 == 0) {
                i += 1
            } else {
                if (tempA[j] % 2 == 0) {
                    tempA.swapAt(i, j)
                    j -= 1
                    i += 1
                } else {
                    j -= 1
                }
            }
        }
        return tempA
    }
}

// 方法 2
class Solution {
    func sortArrayByParity(_ A: [Int]) -> [Int] {
        return A.filter { $0 % 2 == 0 } + A.filter { $0 % 2 != 0 }
    }
}
