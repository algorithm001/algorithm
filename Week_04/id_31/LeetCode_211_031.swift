//
//  LeetCode_211_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/5/16.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class WordDictionary {
    private class TrieNode {
        var children: [Character: TrieNode] = [:]
        var isEnd = false
    }
    
    private let root: TrieNode
    
    init() {
        root = TrieNode()
    }
    
    func addWord(_ word: String) {
        var node = root
        for char in word {
            if node.children[char] == nil {
                node.children[char] = TrieNode()
            }
            node = node.children[char]!
        }
        node.isEnd = true
    }
    
    func search(_ word: String) -> Bool {
        return bfs(self.root, Array(word), 0)
    }
    
    private func bfs(_ node: TrieNode, _ chars: [Character], _ nextIndex: Int) -> Bool {
        if nextIndex == chars.count {
            return node.isEnd
        }
        
        for (nextChar, nextNode) in node.children {
            if chars[nextIndex] == "." || chars[nextIndex] == nextChar {
                if bfs(nextNode, chars, nextIndex + 1) {
                    return true
                }
            }
        }
        
        return false
    }
}
