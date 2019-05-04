/**
609. Find Duplicate File in System

Given a list of directory info including directory path, and all the files with contents in this directory, you need to find out all the groups of duplicate files in the file system in terms of their paths.

A group of duplicate files consists of at least two files that have exactly the same content.

A single directory info string in the input list has the following format:

"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:

"directory_path/file_name.txt"

Example 1:

Input:
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]


Note:

No order is required for the final output.
You may assume the directory name, file name and file content only has letters and digits, and the length of file content is in the range of [1,50].
The number of files given is in the range of [1,20000].
You may assume no files or directories share the same name in the same directory.
You may assume each given directory info represents a unique directory. Directory path and file info are separated by a single blank space.


Follow-up beyond contest:
Imagine you are given a real file system, how will you search files? DFS or BFS?
If the file content is very large (GB level), how will you modify your solution?
If you can only read the file by 1kb each time, how will you modify your solution?
What is the time complexity of your modified solution? What is the most time-consuming part and memory consuming part of it? How to optimize?
How to make sure the duplicated files you find are not false positive?

*/

package solution

import (
	"fmt"
	"regexp"
	"strings"
)

/*
解题思路:
结合哈希表和链表解决; 以文件的内容作为哈希表的键值,文件的路径作为链表的节点的内容;
遍历取出真实数据存放到节点中.
*/

type LinkNode struct {
	Next  *LinkNode
	Value string
}

func NewLinkNode(value string) *LinkNode {
	return &LinkNode{
		Value: value,
	}
}

func insertNode(head *LinkNode, newNode *LinkNode) {
	if head == nil {
		return
	}
	temp := head
	for temp.Next != nil {
		temp = temp.Next
	}
	temp.Next = newNode
}

func traverseMaps(mps map[string]*LinkNode) [][]string {
	backlists := make([][]string, 0)
	kmaps := make(map[string][]string, 0)
	for k, v := range mps {
		kmaps[k] = append(kmaps[k], v.Value)
		for v.Next != nil {
			v = v.Next
			kmaps[k] = append(kmaps[k], v.Value)
		}
	}
	for _, v := range kmaps {
		backlists = append(backlists, v)
	}
	return backlists
}

func findDuplicate(paths []string) [][]string {
	results := make([][]string, 0)
	mps := make(map[string]*LinkNode)
	for _, v := range paths {
		temps := strings.Split(v, " ")
		if len(temps) == 0 {
			continue
		}
		dir := temps[0]
		for _, one := range temps[1:] {
			reg := regexp.MustCompile(`(.*)\((.*)\)`)
			extracts := reg.FindStringSubmatch(one)
			if len(extracts) != 3 {
				continue
			}
			filePath := dir + "/" + extracts[1]
			key := extracts[2]
			nd := NewLinkNode(filePath)

			// 其实此处也可直接定义哈希表的类型为map[string][]string,将相同内容的数据直接存放到slice中;
			// 但是实际需求中数据可能是多维度的,则需要将slice中的数据结构体化,使用数组存放结构体;
			// 使用哈希表之后,其实就将问题转化为链表或者数组问题,实际上就是比较链表和数组的特性
			// 链表优势在于快速插入和删除, 数组优势在直接寻址访问.
			// 另外,当前问题使用链表处理,实际上就比较冗余.
			if hd, ok := mps[key]; ok {
				fmt.Println("key exsits, so new node must be created")
				insertNode(hd, nd)
			} else {
				mps[key] = nd
			}
		}
	}
	results = traverseMaps(mps)
	return results
}
