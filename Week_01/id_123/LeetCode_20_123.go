package id_123

import "github.com/pkg/errors"

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。

type Stack struct {
	data  []byte
	count int
	n     int
}

func (s *Stack) init(n int) {
	s.data = make([]byte, n)
	s.n = n
}

func (s *Stack) push(c byte) error {
	if s.count == s.n {
		return errors.New("Stack full!")
	}

	s.count++
	s.data[s.count-1] = c
	return nil
}

func (s *Stack) pop() (byte, error) {
	if s.count == 0 {
		return 0, errors.New("Stack empty!")
	}

	value := s.data[s.count-1]
	s.count--
	return value, nil
}

func isValid(s string) bool {
	stack := new(Stack)
	stack.init(len(s))

	for _, c := range s {
		if c == '{' || c == '[' || c == '(' {
			stack.push(byte(c))
		} else {
			if stack.count == 0 {
				return false
			} else {
				v, _ := stack.pop()
				if v == '{' && c == '}' {
					continue
				} else if v == '[' && c == ']' {
					continue
				} else if v == '(' && c == ')' {
					continue
				} else {
					return false
				}
			}
		}
	}

	if stack.count == 0 {
		return true
	} else {
		return false
	}
}
