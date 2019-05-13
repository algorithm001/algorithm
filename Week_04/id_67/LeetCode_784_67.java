class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        backtrack(S.toCharArray(), res, new char[S.length()], 0);
        return res;
    }

    private void backtrack(char[] arr, List<String> res, char[] cur, int i) {
        if (i == arr.length) {
            res.add(new String(cur));
            return;
        }
        if (Character.isDigit(arr[i])) {
            cur[i] = arr[i];
            backtrack(arr, res, cur, i + 1);
        } else {
            cur[i] = Character.toLowerCase(arr[i]);
            backtrack(arr, res, cur, i + 1);
            cur[i] = Character.toUpperCase(arr[i]);
            backtrack(arr, res, cur, i + 1);
        }
    }
}