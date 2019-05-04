//
//  LeetCode_783_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/28.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    var result: Set<Int> = []
    func minDiffInBST(_ root: TreeNode?) -> Int {
        guard let _ = root else { return 0 }
        find(root)
        var sortedData: [Int] = Array(result)
        var minValue = -1
        for i in 0...sortedData.count - 1 {
            if (i+1 > sortedData.count - 1) { continue }
            for j in i+1...sortedData.count - 1 {
                minValue = minValue == -1 ? abs(sortedData[i] - sortedData[j]): min(minValue, abs(sortedData[i] - sortedData[j]))
            }
        }
        return minValue
    }
    
    private func find(_ root: TreeNode?) {
        guard let rootv = root else { return }
        result.insert(rootv.val)
        find(root?.left)
        find(root?.right)
    }
}
