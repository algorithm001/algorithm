class Solution {
    func sortArrayByParityII(_ A: [Int]) -> [Int] {
        
        var result = A
        var evenIndex = 0
        var oddIndex = 1
        
        for index in 0..<A.count {
            if A[index] % 2 == 0 {
                result[evenIndex] = A[index]
                evenIndex = evenIndex + 2
            } else {
                result[oddIndex] = A[index]
                oddIndex = oddIndex + 2
            }
        }
        
        return result
    }
}