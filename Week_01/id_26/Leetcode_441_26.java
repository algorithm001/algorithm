// Source : https://leetcode.com/problems/arranging-coins/
// Id     : 441
// Author : Fanlu Hai
// Date   : 2018-04-17
public class ArrangingCoins {

    public int arrangeCoinsWithLong(int n) {
        int rows = 0;
        long coins = 0;
        while (true) {
//            System.out.println(n + "**" + coins + " " + rows);
            if (n > coins) {
                rows++;
                coins += rows;
            } else if (n == coins) {
                return rows;
            } else {
                return rows - 1;
            }
        }
    }

    //faster than 82.04%, smaller than 100%
    public int arrangeCoins(int n) {
        int rows = 0;
        long coins = 0;
        while (true) {
//            System.out.println(n + "**" + coins + " " + rows);
            if (n > 0) {
                rows++;
                // use n - row instead of coins + to avoid int overflow
                n -= rows;
            } else if (n == 0) {
                return rows;
            } else {
                return rows - 1;
            }
        }
    }

    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        System.out.println(arrangingCoins.arrangeCoins(0));
        System.out.println(arrangingCoins.arrangeCoins(1));
        System.out.println(arrangingCoins.arrangeCoins(5));
        System.out.println(arrangingCoins.arrangeCoins(6));
        System.out.println(arrangingCoins.arrangeCoins(8));
        System.out.println(arrangingCoins.arrangeCoins(2147483647));
    }
}
