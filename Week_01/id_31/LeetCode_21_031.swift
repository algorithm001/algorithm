//
//  LeetCode_21_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/15.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

// 时间复杂度O(n) ; n为maxCount(l1.count, l2.count)
class Solution {
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        var result: [Int] = []
        
        let a1 = converToArryFrom(l1)
        let a2 = converToArryFrom(l2)
        
        var i = 0
        var j = 0
        
        while true {
            if (i >= a1.count || j >= a2.count) {
                if (j <= a2.count - 1) { result = result + a2[j...a2.count - 1] }
                if (i <= a1.count - 1) { result = result + a1[i...a1.count - 1] }
                break;
            }
            
            if (a1[i] == a2[j]) {
                result.append(a1[i])
                result.append(a2[j])
                i += 1
                j += 1
            } else if ((a1[i] < a2[j])) {
                result.append(a1[i])
                i += 1
            } else {
                result.append(a2[j])
                j += 1
            }
        }
        return convertToNodeFrom(result)
    }
    
    private func converToArryFrom(_ node: ListNode?) -> [Int] {
        var resultArr: [Int] = []
        guard let _ = node else { return resultArr }
        var currentNode = node
        while let current = currentNode {
            resultArr.append(current.val)
            currentNode = currentNode?.next
        }
        return resultArr
    }
    
    private func convertToNodeFrom(_ arr: [Int]) -> ListNode? {
        guard arr.count > 0 else { return nil }
        var result: ListNode?
        var resultHeader: ListNode?
        for v in arr {
            if result == nil {
                result = ListNode(v)
                resultHeader = result
            } else {
                result?.next = ListNode(v)
                result = result?.next
            }
        }
        return resultHeader
    }
}
