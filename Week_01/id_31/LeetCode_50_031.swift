//
//  LeetCode_50_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/20.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func myPow(_ x: Double, _ n: Int) -> Double {
        if n == 0 { return 1 }
        if n == 1 { return x }
        let tempValue = myPow(x, n/2)
        if (n % 2 == 0) {
            return tempValue * tempValue
        } else {
            return pow(x, Double(n + 1)) / x
        }
    }
}
