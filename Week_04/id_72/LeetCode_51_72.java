class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        if (n < 0) {
            return result;
        }
        List<List<Integer>> queensResult = new LinkedList<>();
        List<Integer> queens = new LinkedList<>();
        for (int j = 0; j < n; j++) {
            dfs(queensResult, queens, 0, j, n);
        }
        return print(queensResult);
    }

    private boolean dfs(List<List<Integer>> result, List<Integer> queens, int i, int j, int n) {
        if (i >= n) {
            return true;
        }
        if (!checkPosition(queens, i, j)) {
            return false;
        }
        queens.add(i, j);
        for (int m = 0; m < n; m++) {
            if (dfs(result, queens, i + 1, m, n)) {
                result.add(new LinkedList<>(queens));
                break;
            }
        }
        queens.remove(i);
        return false;
    }

    private boolean checkPosition(List<Integer> queens, int i, int j) {
        if (queens == null || queens.isEmpty()) {
            return true;
        }
        for (Integer n : queens) {
            if (j == n) {
                return false;
            }
            int m = queens.indexOf(n);
            if (i == m) {
                return false;
            }
            if (n - m == j - i) {
                return false;
            }
            if (n + m == j + i) {
                return false;
            }
        }
        return true;
    }

    private List<List<String>> print(List<List<Integer>> queensResult) {
        List<List<String>> result = new LinkedList<>();
        for (List<Integer> queens : queensResult) {
            List<String> queenStrList = new LinkedList<>();
            for (int i = 0; i < queens.size(); i++) {
                Integer queen = queens.get(i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < queens.size(); j++) {
                    if (j == queen) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                queenStrList.add(sb.toString());
            }
            result.add(queenStrList);
        }
        return result;
    }
}