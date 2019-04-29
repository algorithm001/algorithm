//
//  LeetCode_242_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/18.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        if (s.count != t.count) { return false }
        var collect: [Character: Int] = [:]
        for sChar in s {
            if collect.keys.contains(sChar), var sValue = collect[sChar] {
                sValue += 1
                collect[sChar] = sValue
            } else {
                collect[sChar] = 1
            }
        }
        
        for tChar in t {
            if collect.keys.contains(tChar), var tValue = collect[tChar], tValue > 0 {
                tValue -= 1
                if (tValue == 0) {
                    collect.removeValue(forKey: tChar)
                } else {
                    collect[tChar] = tValue
                }
            }
        }
        return collect.isEmpty
    }
}
