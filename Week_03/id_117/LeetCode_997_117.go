package solution

/*
997. Find the Town Judge

In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.



Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3


Note:

1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N
*/

/**
 * <pre>
 *   需求描述：
 *     1. 小镇的法官不相信任何人。
 *          没有指向的顶点。   出度=0
 *     2. 每个人（除了小镇法官外）都信任小镇的法官。
 *          其他的点，都指向这个顶点。秘密的法官的  入度=N-1
 *     3. 只有一个人同时满足属性 1 和属性 2 。
 *          只能有一个顶点的。出度=0，入度=N-1
 *
 *     +-----+----+
 *     |入度 |出度 |
 *     +-----+----+
 *     | N-1 | 0  |  -->  秘密法官
 *     +-----+----+
 *     |0.N-1| >0 |  -->  其他
 *     +-----+----+
 *
 * </pre>
 */

// 使用两个map分别存放第一个值和第二个值 时间复杂度 O(2n), 空间复杂度O(2n)
func findJudge(N int, trust [][]int) int {
	tlen := len(trust)
	mpsSecond := make(map[int]int, 0)
	mpsFirst := make(map[int]int, 0)
	for idx := 0; idx < tlen; idx++ {
		unit := trust[idx]
		if _, ok := mpsFirst[unit[0]]; !ok {
			mpsFirst[unit[0]] = 1
		}
		mpsSecond[unit[1]] = mpsSecond[unit[1]] + 1
	}
	bkNum := -1
	for k := range mpsSecond {
		if _, ok := mpsFirst[k]; ok {
			continue
		}
		bkNum = k
		break
	}
	return bkNum
}

// 如果只使用一个map,怎样保证不增加时间复杂度, map可以存储负数,将第二个值作为负的键值存储,这种方式似乎和用两个map内存空间使用相同
// 使用map+链表的方式稍显麻烦,这也是图里面的逆邻接表
