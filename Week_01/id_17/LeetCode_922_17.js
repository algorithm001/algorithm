var sortArrayByParityII = function(A) {
    var j = 1;
    for (var i=0, j=1; i<A.length; i+=2)
        if (A[i] % 2 == 1) {
            while (A[j] % 2 == 1) j += 2;
            [A[i], A[j]] = [A[j], A[i]]
        }
    return A;
};

// Runtime: 120 ms, faster than 50.18% of JavaScript online submissions for Sort Array By Parity II.
// Memory Usage: 38.2 MB, less than 98.85% of JavaScript online submissions for Sort Array By Parity II.