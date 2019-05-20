//
//  LeetCode_746_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/5/20.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func minCostClimbingStairs(_ cost: [Int]) -> Int {
        guard cost.count >= 2 else { return 0 }
        var dp: [Int: Int] = [:]
        dp[0] = cost[0]
        dp[1] = cost[1]
        for i in 2..<cost.count {
            dp[i] = min(dp[i-1]!, dp[i-2]!) + cost[i]
        }
        return min(dp[cost.count - 1]!, dp[cost.count - 2]!)
}

