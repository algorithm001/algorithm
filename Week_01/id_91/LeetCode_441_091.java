/**
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * https://leetcode-cn.com/problems/arranging-coins/
 * @author jidw
 */
class Solution {
    public int arrangeCoins(int n) {
        if(n == 1){
            return 1;
        }
        long nlong = (long) n;

        long start = 0, end = nlong;
        while(start + 1 < end){
            long mid = start + (end - start) / 2;

            if(mid*(mid+1) <= 2*nlong){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        return (int)(start);
    }
}