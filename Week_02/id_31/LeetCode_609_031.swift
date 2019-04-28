//
//  LeetCode_609_031.swift
//  TestCoding
//
//  Created by 龚欢 on 2019/4/22.
//  Copyright © 2019 龚欢. All rights reserved.
//

import Foundation

class Solution {
    func findDuplicate(_ paths: [String]) -> [[String]] {
        // 定义一个哈希Map, key: 文件名（文件内容） value: [路径] (这里为去重，我用了Set数据结构)
        var result: [String: [String]] = [:]
        var data: [[String]] = []
        _ = paths.map {
            let splitDatas = $0.split(separator: " ")
            guard splitDatas.count > 1 else { return }
            let filePath = String(splitDatas[0])
            for i in 0...splitDatas.count - 1 where i != 0 {
                let analysisValues = getRealContentFrom(input: String(splitDatas[i]))
                if var filePathCollect = result[analysisValues.content] {
                    filePathCollect.append("\(filePath)/\(analysisValues.name)")
                    result[analysisValues.content] = filePathCollect
                } else {
                    var collect: [String] = []
                    collect.append("\(filePath)/\(analysisValues.name)")
                    result[analysisValues.content] = collect
                }
            }
        }
        for (_, v) in result where v.count > 1 { data.append(v) }
        return data
    }

    private func getRealContentFrom(input: String) -> (content: String, name: String) {
        let kStart = input.firstIndex(of: "(")
        let kEnd = input.lastIndex(of: ")")
        guard let start = kStart, let end = kEnd else { return (content: "", name: "") }
        return (content: String(input[input.index(start, offsetBy: 1)..<end]), name: String(input[input.startIndex..<start]))
    }
}
