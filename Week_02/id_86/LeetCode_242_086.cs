using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{
    class LeetCode_242_086
    {
        /// <summary>
        /// 104ms 21.7MB
        /// </summary>
        /// <param name="s"></param>
        /// <param name="t"></param>
        /// <returns></returns>
        public bool MethodFor242_1(string s, string t)
        {
            if (s.Length != t.Length) return false;

            Dictionary<char, int> d = new Dictionary<char, int>();

            for (int i = 0; i < s.Length; i++)
            {
                if (d.ContainsKey(s[i]))
                {
                    d[s[i]]++;

                    if (d[s[i]] == 0)
                    {
                        d.Remove(s[i]);
                    }
                }
                else
                {
                    d.Add(s[i],1);
                }

                if (d.ContainsKey(t[i]))
                {
                    d[t[i]]--;

                    if (d[t[i]]==0)
                    {
                        d.Remove(t[i]);
                    }
                }
                else
                {
                    d.Add(t[i], -1);
                }
            }

            return d.Count==0;
        }
    }
}
