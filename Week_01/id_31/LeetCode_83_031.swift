//
//  LeetCode_83_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/15.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

// 解法1：时间复杂度O(n), 空间复杂度O(Node中不同的value的结点个数)
class Solution {
    var temp: [Int] = []
    func deleteDuplicates(_ head: ListNode?) -> ListNode? {
        guard let _ = head else { return nil }
        var currentNode: ListNode? = head
        var preNode: ListNode? = nil
        var result: ListNode?
        var resultHeader: ListNode?
        while let current = currentNode {
            if (temp.contains(current.val)) {
                preNode?.next = currentNode?.next
            } else {
                if (result == nil) {
                    result = ListNode(current.val)
                    resultHeader = result
                } else {
                    result?.next = ListNode(current.val)
                    result = result?.next
                }
                temp.append(current.val)
            }
            preNode = currentNode
            currentNode = currentNode?.next
        }
        return resultHeader
    }
}

// 解法2：时间复杂度O(2n), 空间复杂度O(Node中不同的value的结点个数)
class Solution {
    var temp: [Int] = []
    func deleteDuplicates(_ head: ListNode?) -> ListNode? {
        guard let _ = head else { return nil }
        var currentNode: ListNode? = head
        while let current = currentNode {
            if (!temp.contains(current.val)) { temp.append(current.val) }
            currentNode = currentNode?.next
        }
        return convertToNodeFrom(temp)
    }
    
    private func convertToNodeFrom(_ arr: [Int]) -> ListNode? {
        guard arr.count > 0 else { return nil }
        var result: ListNode?
        var resultHeader: ListNode?
        for v in temp {
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
