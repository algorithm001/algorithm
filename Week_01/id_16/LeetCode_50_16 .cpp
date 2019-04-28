/**[二分查找][中等]
实现 pow(x, n) ，即计算 x 的 n 次幂函数。
示例 1:
输入: 2.00000, 10
输出: 1024.00000
示例 2:
输入: 2.10000, 3
输出: 9.26100
示例 3:
输入: 2.00000, -2
输出: 0.25000
解释: 2^-2 = 1/2^2 = 1/4 = 0.25
说明:
-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
*/

/*
个人感悟：
第一种思路好想，但是执行效率不好，
思路2与思路3思想差不多，思路2需要考虑边界条件，思路3巧妙的避开了。
对于用递归还是用for循环还是要多多练习！
要充分考虑数据范围及边界条件。
*/

/*未通过：超时
思路1：for循环累乘
结果：超出时间限制
*/

/*未通过：执行错误
思路2：用递归实现，x^n = (x^(n/2))^2
测试用例：
1.00000
-2147483648
*/
class Solution {
public:
    double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n < 0) return (1 / myPow(x, -n));  //negation of -2147483648 cannot be represented in type 'int'
        double res;
        if(n % 2 == 0){
            res = myPow(x, n/2);
            res *= res;
        }else{
            res = myPow(x, (n-1)/2);
            res = res*res*x;
        }
        return res;
    }
};

/*通过
思路3：用for循环实现，x^n = (x^2)^(n/2)
注意：代码中i=1时刻需要注意
*/
class Solution {
public:
    double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0) res *= x;
            x *= x;
        }
        return n > 0 ? res : 1/res;
    }
};