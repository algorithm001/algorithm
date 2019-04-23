//
//  LeetCode_441_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/19.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func arrangeCoins(_ n: Int) -> Int {
        var total = 0
        var k = 1
        let n = n
        while n >= k {
            total += k
            if total == n {
                return k
            } else if total > n {
                return k - 1
            }
            k += 1
        }
        return 0
    }
}
