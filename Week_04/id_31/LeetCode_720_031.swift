//
//  LeetCode_720_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/5/11.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func longestWord(_ words: [String]) -> String {
        let sortedWords = Set(words).sorted {
            if $0.count == $1.count {
                return $0 < $1
            } else {
                return $0.count > $1.count
            }
        }
        var errorDatas: Set<String> = []
        for key in sortedWords {
            if (errorDatas.contains(key)) { continue }
            for i in 1...key.count {
                let subString = String(key[key.startIndex..<key.index(key.startIndex, offsetBy: i)])
                if (sortedWords.contains(subString)) {
                    if i == key.count { return key }
                    continue
                } else {
                    errorDatas.insert(key)
                    break
                }
            }
        }
        return ""
    }
}
