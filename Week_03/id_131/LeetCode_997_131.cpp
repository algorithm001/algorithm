/*
  997.找到小镇的法官
  在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。

如果小镇的法官真的存在，那么：

    小镇的法官不相信任何人。
    每个人（除了小镇法官外）都信任小镇的法官。
    只有一个人同时满足属性 1 和属性 2 。

给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。

如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
*/
/*
  思路：
  用一个二维数组记录每个结点的入度和出度，出度为0入度为N的就是法官
*/
class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        // 二维数组 第 i 行-记录 i+1 的出度和入度
        int people[N][2]  = {0};
        for(int i = 0; i < trust.size(); ++i)
        {
            // 第 outD 行的出度 +1
            int outD = trust[i][0];
            people[outD-1][0]++;
            // 第 inD 行的入度 +1
            int inD = trust[i][1];
            people[inD-1][1]++;
        }
        for(int i = 0; i < N; ++i)
        {
            if(people[i][0] == 0 && people[i][1] == N-1)
            {
                return i+1;
            }
        }
        return -1;
    }
};