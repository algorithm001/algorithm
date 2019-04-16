/**
  * 思路：
  *     例图: n=5
  *       *
  *       **
  *       **
  *       从图中可以看出，本题中如果是正常的梯形，第一行 1 *，第二行 2 ** ，第三行 3 *** .. 
  *       因此使用 index 来标记行，每排列一行，n 就要减去对应的行数，
  *       也就是 第一行 index = 1， 排列之后, n 还剩 n=n-index=4, 第二行 index = 2，排列之后 n=n-index=2
  *       依次类推，知道 n < index 时，就无法再行程梯形了。
  *       时间复杂度应该是 O(n) 吧，
  *       还有一种方式就是利用 梯形公式；
  */

class Solution {
    public int arrangeCoins(int n) {
        if(n==1)
            return 1;
        int index = 1;
        while(index<=n){
            n = n-index;
            index = index+1;
            if(n<index){
                break;
            }
        }
        return index-1;
    }
}
