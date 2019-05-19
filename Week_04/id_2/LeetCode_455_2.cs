public class Solution {
    public int FindContentChildren(int[] g, int[] s) {
        Array.Sort(g);
        Array.Sort(s);
        int children = 0;
        int cookies = 0;
        while(children < g.Length && cookies < s.Length)
        {
            if(g[children] <= s[cookies])
            {
                children++;
            }
            cookies++;
        }
        return children;
    }
}
