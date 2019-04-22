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
        // 定义一个哈希Map来存放数据，key: 单词，value: (首字母，单词出现的个数)
        var collect: [String: (char: String, count: Int)] = [:]
        var sortedResetCollect: [String] = []
        // 第一次遍历，统计单词出现的次数、首字母
        for i in 0...words.count - 1 {
            let w = words[i]
            if var t = collect[words[i]] {
                t.count += 1
                collect[words[i]] = t
            } else {
                collect[words[i]] = (char: w, count: 1)
            }
        }
        // 针对这个哈希Map排序，情况1：将单词出现数量多的排在前面   情况2：如果出现的数量相同的情况下，比较首字母
        let sortedCollect = collect.sorted {
            if $0.value.count != $1.value.count {
                return $0.value.count > $1.value.count
            } else {
                return $0.value.char < $1.value.char
            }
        }
        // 只取前K个元素，用局部变量Index来统计数量
        var index = 0
        for (key, _) in sortedCollect {
            if index >= k { break }
            sortedResetCollect.append(key)
            index += 1
        }
        return sortedResetCollect
    }
}
