import java.util.Arrays;

class Solution {

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        int max = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int cursor = 0;
        // assign cookies from the child who is easiest to be contented
        for (int greedFactor : g) {
            // find the cookie that can content the current child
            while (cursor < s.length) {
                // for the next child, check cookies starting from cursor++
                // because the cookies that are smaller than the current one can't content the next child
                int cookieSize = s[cursor++];
                if (cookieSize >= greedFactor) {
                    max++; // find the smallest cookie that can content this child.
                    break; // move to the next child
                }
            }
        }
        return max;
    }
}
