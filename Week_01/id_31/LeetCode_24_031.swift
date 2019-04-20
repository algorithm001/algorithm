//
//  LeetCode_24_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/15.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

// 时间复杂度O(n) 
class Solution {
    var stack: [Int] = []
    func swapPairs(_ head: ListNode?) -> ListNode? {
        guard let h = head else { return nil }
        
        var currentNode: ListNode? = head
        var dump: ListNode? = ListNode(h.val)
        let resultHeader: ListNode? = dump
        
        while let current = currentNode {
            if (stack.count == 0) {
                stack.append(current.val)
            } else {
                let willPopNodeValue = stack.removeFirst()
                dump?.next = ListNode(current.val)
                dump = dump?.next
                dump?.next = ListNode(willPopNodeValue)
                dump = dump?.next
            }
            currentNode = currentNode?.next
        }
        if (stack.count > 0) { dump?.next = ListNode(stack[0])}
        
        return resultHeader?.next
    }
}
