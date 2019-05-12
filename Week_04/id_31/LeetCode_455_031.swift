//
//  LeetCode_455_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/5/12.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func findContentChildren(_ g: [Int], _ s: [Int]) -> Int {
        var res: Int = 0
        var sortedG = g.sorted { $0 < $1 }
        var sortedS = s.sorted { $0 < $1 }
        // 先满足胃口最小的孩子
        for i in 0..<sortedG.count {
            let gg = sortedG[i]
            
            var sIndex = 0
            while sIndex <= sortedS.count - 1 {
                let ss = sortedS[sIndex]
                if (ss >= gg) {
                    // 找到满足这个孩子胃口的食物了,并且在食物列表中移除它
                    sortedS.remove(at: sIndex)
                    // 记录一下满足孩子的个数
                    res += 1
                    // 退出此次循环
                    break
                }
                sIndex += 1
            }
        }
        return res
    }
}
