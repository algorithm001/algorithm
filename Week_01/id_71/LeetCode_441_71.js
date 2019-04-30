/**
 * @param {number} n
 * @return {number}
 */
var arrangeCoins = function (n) {
    if (n === 0) {
        return 0
    }
    let temp = n
    for (let i = 1; i <= n; i++) {
        temp = temp - i
        if (temp === 0 || temp < i + 1) {
            return i
        }
    }
};