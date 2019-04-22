//
//  Leetcode50PowX2N.swift
//  AlgorithmPractice
//
//  Created by Ryeagler on 2019/4/22.
//  Copyright © 2019 Ryeagle. All rights reserved.
//

import Foundation

struct LeetCode50PowX_N {
     func myPow(_ x: Double, _ n: Int) -> Double {
        var x = x
        var n = n
        if n == 0 {
            return 1;
        }
        if n < 0 {
            n = -n;
            x = 1 / x;
        }
        return ( n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
