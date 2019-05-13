//
//  LeetCode_784_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/5/12.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    var m: [String] = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    var n: [String] = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
    var res: Set<String> = []
    func letterCasePermutation(_ S: String) -> [String] {
        var s = S
        _ = find(&s, 0)
        return Array(res)
    }
    
    private func find(_ S: inout String, _ from: Int) {
        if from == S.count {
            return
        }
        guard let offSetStart = S.index(S.startIndex, offsetBy: from, limitedBy: S.endIndex), let offSetEnd   = S.index(offSetStart, offsetBy: 1, limitedBy: S.endIndex) else { return }
        let findRange = offSetStart..<offSetEnd
        let findWord = String(S[findRange])
        if m.contains(findWord) || n.contains(findWord) {
            // 可以切换大小写
            // 1. 不切换大小写
            res.insert(S)
            find(&S, from + 1)
            
            // 2. 切换大小写
            if (m.contains(findWord)) {
                S = S.replacingOccurrences(of: findWord, with: n[m.index(of: findWord)!], options:[], range: findRange)
            } else if (n.contains(findWord)) {
                S = S.replacingOccurrences(of: findWord, with: m[n.index(of: findWord)!], options:[], range: findRange)
            }
            res.insert(S)
            find(&S, from + 1)
        } else {
            res.insert(S)
            find(&S, from + 1)
        }
    }
}
