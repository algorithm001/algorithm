//
//  LeetCode_687_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/19.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func longestUnivaluePath(_ root: TreeNode?) -> Int {
        guard let _ = root else { return 0 }
        let childrenPath = max(longestUnivaluePath(root?.left), longestUnivaluePath(root?.right))
        let s = search(root)
        let rootPath = s.left + s.right
        return max(childrenPath, rootPath)
    }
    
    private func search(_ root: TreeNode?) -> (left: Int, right: Int) {
        guard let rootv = root else { return (left: 0, right: 0) }
        var leftv: Int = 0
        var rightv: Int = 0
        if rootv.left?.val == rootv.val {
            leftv = 1 + findMax(search(root?.left))
        }
        if rootv.right?.val == rootv.val {
            rightv = 1 + findMax(search(root?.right))
        }
        return (left: leftv, right: rightv)
    }
    
    private func findMax(_ t: (Int, Int)) -> Int {
        return max(t.0, t.1)
    }
}
