import org.junit.Test;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/29
 */
public class LeetCode_174_108 {

    /**
     * 利用动态规划，构造到达某个节点时的最小生命值,最小存活值是1
     * 1、如果是最后一个，到达最后一个点时的存活值就是（1-健康点数，1）的最大值，必须大于等于1，要不就立即死亡
     * 2、如果是最下面一行的点，那么到达它的最小存活着就是=（右边一个点的最小存活值-自己的健康点数，1）的最大值，表示进入我这个点时得具有多少个健康值才能顺利进入下一个点
     * 3、如果是最右边一列，跟上面同理，只不过比较的是下面的点，因为只能往右或往下走
     * 4、如果是中间的某个点，那么肯定找个门槛最低的点走，所以比较下面和右边的点，找到最小值，再跟1比较
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length - 1;
        int column = dungeon[0].length - 1;
        for (int i = row; i >= 0; i--) {
            for (int j = column; j >= 0; j--) {
                if (i == row && j == column) {
                    dungeon[i][j] = Math.max(1 - dungeon[i][j], 1);
                } else if (i == row) {
                    dungeon[i][j] = Math.max(dungeon[i][j + 1] - dungeon[i][j], 1);
                } else if (j == column) {
                    dungeon[i][j] = Math.max(dungeon[i + 1][j] - dungeon[i][j], 1);
                } else {
                    dungeon[i][j] = Math.max(Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j], 1);
                }
            }
        }
        return dungeon[0][0];
    }
}
