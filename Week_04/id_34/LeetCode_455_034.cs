public class Solution {
    public int FindContentChildren(int[] g, int[] s) {
            var children = g.OrderBy(p => p).ToList();
            var cookies = s.OrderBy(p => p).ToList();
            int matchs = 0;
            int lastIndex = 0;
            for (int i = 0; i < children.Count; i++)
            {
                for (int j = lastIndex; j < cookies.Count; j++)
                {
                    if (cookies[j] >= children[i])
                    {
                        matchs++;
                        lastIndex = j+1;
                        break;
                    }
                }
            }

            return matchs;
    }
}
