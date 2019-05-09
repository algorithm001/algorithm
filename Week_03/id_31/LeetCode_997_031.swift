//
//  LeetCode_997_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/5/4.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    var beTrusted : Set<Int> = []
    var datas: [Int: Set<Int>] = [:]
    func findJudge(_ N: Int, _ trust: [[Int]]) -> Int {
        // 法官自己
        if N == 1 && trust.isEmpty { return 1 }
        guard trust.count > 0 else { return -1 }
        for value in trust {
            guard value.count == 2 else { return -1}
            let p1 = value[0]
            let p2 = value[1]
            if var v = datas[p1] {
                v.insert(p2)
                datas[p1] = v
            } else {
                var temp: Set<Int> = []
                temp.insert(p2)
                datas[p1] = temp
            }
            beTrusted.insert(p2)
        }
        if beTrusted.isEmpty {
            return -1
        } else if beTrusted.count == 1 {
            return beTrusted.first!
        } else {
            var compareSet: Set<Int>? = nil
            for (_, v) in datas {
                if let compare = compareSet {
                    let tempSet = compare.intersection(v)
                    guard !tempSet.isEmpty else { return -1 }
                    compareSet = tempSet
                } else {
                    compareSet = v
                }
            }
            if let com = compareSet, com.count == 1 {
                return com.first!
            } else {
                return -1
            }
        }
    }
}
