class Solution {
    func isValid(_ s: String) -> Bool {
        var stack1 = Stack(Array(s))
        var stack2 = Stack([Character]())

        while !stack1.isEmpty {
            let a = stack1.pop()!
            if let b = stack2.peek() {
                if map(a) > 0 && map(a)+map(b) == 0 {
                    stack2.pop()
                } else {
                    stack2.push(a)
                }
            } else {
                stack2.push(a)
            }
        }

        if stack2.isEmpty {
            return true
        } else {
            return false
        }
    }

    func map(_ character: Character) -> Int {
        switch character {
        case "(": return 1
        case ")": return -1
        case "{": return 2
        case "}": return -2
        case "[": return 4
        case "]": return -4
        default: return 0
        }
    }
}

struct Stack<Element> {
	
	private var storage: [Element] = []
	
	public init(_ elements: [Element]) {
		storage = elements
	}
	
	public mutating func push(_ element: Element) {
		storage.append(element)
	}
	
	@discardableResult
	public mutating func pop() -> Element? {
		return storage.popLast()
	}
	
	func peek() -> Element? {
		return storage.last
	}
	
	public var isEmpty: Bool {
		return peek() == nil
	}
}

// Runtime: 12 ms, faster than 52.39% of Swift online submissions for Valid Parentheses.
// Memory Usage: 19.7 MB, less than 12.25% of Swift online submissions for Valid Parentheses.