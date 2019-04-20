var sortArrayByParity = function(A) {
    for (var i=0, j=A.length-1; i<j; i++, j--) {
        while (A[i]%2 == 0) if (i>=j) break; else i++;
        while (A[j]%2 == 1) if (i>=j) break; else j--;
        [A[i], A[j]] = [A[j], A[i]];
    }
    return A;
};

// Runtime: 84 ms, faster than 93.15% of JavaScript online submissions for Sort Array By Parity.
// Memory Usage: 37.3 MB, less than 40.08% of JavaScript online submissions for Sort Array By Parity.