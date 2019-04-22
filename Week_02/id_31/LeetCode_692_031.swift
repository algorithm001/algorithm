//
//  LeetCode_692_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/22.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func topKFrequent(_ words: [String], _ k: Int) -> [String] {
        var collect: [String: (word: String, count: Int)] = [:]
        var index = 0
        var sortedResetCollect: [String] = []
        for i in 0...words.count - 1 {
            let w = words[i]
            if var t = collect[words[i]] {
                t.count += 1
                collect[words[i]] = t
            } else {
                collect[words[i]] = (word: w, count: 1)
            }
        }
        let sortedCollect = collect.sorted {
            if $0.value.count != $1.value.count {
                return $0.value.count > $1.value.count
            } else {
                return $0.value.word < $1.value.word
            }
        }
        for (key, _) in sortedCollect {
            if index >= k { break }
            sortedResetCollect.append(key)
            index += 1
        }
        return sortedResetCollect
    }
}
