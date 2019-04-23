//
//  LeetCode_20_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/16.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    var stack: [Character] = []
    func isValid(_ s: String) -> Bool {
        _ = s.map {
            if let lastChar = stack.last, ((lastChar == "{" && $0 == "}") || (lastChar == "(" && $0 == ")") || (lastChar == "[" && $0 == "]")) {
                stack.removeLast()
            } else {
                stack.append($0)
            }
        }
        return stack.isEmpty
    }
}
