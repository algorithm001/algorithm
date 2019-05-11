//
//  LeetCode_104_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/5/5.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func maxDepth(_ root: TreeNode?) -> Int {
        return findDepth(root)
    }
    
    private func findDepth(_ root: TreeNode?) -> Int {
        guard let _ = root else { return 0 }
        
        let left = findDepth(root?.left)
        let right = findDepth(root?.right)
        
        return max(left, right) + 1
    }
}
