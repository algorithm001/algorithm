class Solution {
  public int findContentChildren(int[] g, int[] s) {
    if (g.length == 0 || s.length == 0) {
      return 0;
    }
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0;
    int j = 0;
    int count = 0;
    for (; i < g.length ; i++) {
      while (j < s.length) {
        if (g[i] > s[j]) {
          j++;
        } else {
          count++;
          j++;
          break;
        }
      }
    }
    return count;
  }
}