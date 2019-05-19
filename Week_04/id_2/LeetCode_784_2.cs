public class Solution
{
    List<string> result = new List<string>();
    public IList<string> LetterCasePermutation(string S)
    {

        Helper(S, "", 0);

        return result;
    }
    public void Helper(string s, string cur, int i)
    {
        if (i == s.Length)
        {
            result.Add(cur);
            return;
        }
        if (char.IsDigit(s[i]))
        {
            Helper(s, cur + s[i], i + 1);
        }
        else
        {
            Helper(s, cur + char.ToLower(s[i]), i + 1);
            Helper(s, cur + char.ToUpper(s[i]), i + 1);
        }
    }
}
