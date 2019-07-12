package main

/**
	
	方法一：正常方法推演之两个字符串向前推演
		"...a" (word1) => "...b" (word2)
		 ...b     (i)
		 ...a    (j)
		结论1. 当word2、word1的某个节点字符相等时，直接取前一对位置的值即可，应为当前没操作。（两个字符串同时前移后，dp[i-1][j-1]）
			dp[i][j] = dp[i-1][j-1] (word2[i] == word1[j])
		结论2. 当word2、word1的某个节点字符不相等时，可做的操作有
			替换：dp[i][j] = dp[i-1][j-1]+1 (将b替换成a)
			删除：dp[i][j] = dp[i-1][j] +1  (删除b)
			增加：dp[i][j] = dp[i][j-1] +1  （增加a）

	方法二：按照两个结论画图
		两个结论如下：
			1. 当前位置对应两个word的字符相等，取当前位置的斜上角（也就是方法一中结论1）
			2. 当前位置对应两个word的字符不相等，需要从当前位置的斜上角、正上方、左前方的三个值取最小，然后+1（也就是方法一中结论2）
	"ab" => "abc"
         a b c
       0 1 2 3
	 	 a 1 0 1 2
     b 2 1 0 1

 */
func minDistance(word1 string, word2 string) int {
	w1 := len(word1)
	w2 := len(word2)

	dp := make([][]int, w2+1)
	for i := 0; i < w2+1; i++ {
		dp[i] = make([]int, w1+1)
	}

	for i := 1; i < w2+1;i++ {
		dp[i][0] = i
	}

	for i:=1;i<w1+1 ; i++ {
		dp[0][i] = i;
	}

	for i:=1;i<w2+1 ;i++ {
		for j:=1;j<w1+1 ;j++  {

			if word2[i-1] == word1[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = min(dp[i-1][j-1]+1, dp[i][j-1]+1, dp[i-1][j]+1)
			}
		}
	}

	return dp[w2][w1]
}

func min( j int, i int, k int) int {
	if i<j {
		if k < i {
			return k
		}
		return i
	} else {
		if k<j {
			return k
		}
		return j
	}
}
