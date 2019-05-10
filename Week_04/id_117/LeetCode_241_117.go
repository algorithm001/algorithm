package solution

import (
	"fmt"
	"strconv"
)

/*
241. Different Ways to Add Parentheses

Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
*/

/*
方法1,直接for遍历,然后根据运算符来执行判断, 为了减少计算次数,最好使用map来保存已经计算的值
*/

func diffWaysToCompute(input string) []int {
	ans := make([]int, 0)
	for i := 0; i < len(input); i++ {
		if input[i] == '-' || input[i] == '+' || input[i] == '*' {
			parts1 := input[0:i]
			parts2 := input[i+1:]
			parts1Res := diffWaysToCompute(parts1)
			parts2Res := diffWaysToCompute(parts2)
			for _, m := range parts1Res {
				for _, n := range parts2Res {
					c := 0
					if input[i] == '*' {
						c = m * n
					}
					if input[i] == '+' {
						c = m + n
					}
					if input[i] == '-' {
						c = m - n
					}
					ans = append(ans, c)
				}
			}
		}
	}

	if len(ans) == 0 {
		x, _ := strconv.Atoi(input)
		ans = append(ans, x)
	}

	return ans
}

/*
分析:
1.有多少个运算符就有多少个括号
2.从第一个数开始递归查找,每一个运算符都有两种方式
3.表达式如何存储?
*/
func diffWaysToCompute2(input string) []int {
	exps := make([]string, 0) // 表达式
	ans := make([]int, 0)     // 表达式计算值
	curStr := input
	compute(input, &exps, curStr)
	return ans
}

func compute(input string, exps *[]string, curStr string) {
	// 主逻辑, 每次去掉一个数字和运算符
	symbolNum := len(input) / 2
	if symbolNum == 1 {
		return
	}
	fmt.Println("curStr ====>", curStr)
	// 左边第一个数加i+1个括号
	for i := 0; i < symbolNum; i++ {
		curStr = fmt.Sprintf("(%s)", curStr)
		fmt.Println("curStr ===>", curStr)
		compute(input[2:], exps, curStr)
	}
}

/*
设想:
1.是否可以将操作符和数字分别取出来,然后计算
2.是否可以使用动态规划来实现,在某一个数字的组合种类为前面组合种类递推
*/
