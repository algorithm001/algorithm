//
//  LeetCode_671_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/26.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    var datas: Set<Int> = []
    func findSecondMinimumValue(_ root: TreeNode?) -> Int {
        guard let _ = root else { return -1 }
        find(root)
        guard datas.count > 1 else { return -1 }
        return datas.sorted { $0 < $1 }[1]
    }
    
    private func find(_ root: TreeNode?) {
        guard let rootv = root else { return }
        datas.insert(rootv.val)
        find(root?.left)
        find(root?.right)
    }
}
