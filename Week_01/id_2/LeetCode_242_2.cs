using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace leetcode
{
    class _242_有效的字母异位词
    {
        public bool IsAnagram(string s, string t)
        {
            if ((s == string.Empty && t == string.Empty) || s == t)
            {
                return true;
            }

            int[] a = new int[26];
            for (int i = 0; i < s.Length; i++)
            {
                a[s[i] - 'a']++;
            }

            for (int i = 0; i < t.Length; i++)
            {
                a[t[i] - 'a']--;
            }

            for (int i = 0; i < a.Length; i++)
            {
                if (a[i] != 0)
                {
                    return false;
                }
            }

            return true;
        }
    }
}
