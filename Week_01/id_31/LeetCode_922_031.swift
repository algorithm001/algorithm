//
//  LeetCode_922_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/15.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

// 时间复杂度: O(n/2) 空间复杂度:O(n)
class Solution {
    func sortArrayByParityII(_ A: [Int]) -> [Int] {
        guard A.count > 0 else { return [] }
        var result: [Int] = []
        let even = A.filter { $0 % 2 == 0 }
        let odd  = A.filter { $0 % 2 != 0 }
        for i in 0..<even.count {
            result.append(even[i])
            result.append(odd[i])
        }
        return result
    }
}
