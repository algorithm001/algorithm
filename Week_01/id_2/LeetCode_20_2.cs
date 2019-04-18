using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace leetcode
{
    public class 有效的括号
    {
        public bool IsValid(string s)
        {
            Stack<char> ts = new Stack<char>();
            Dictionary<char, char> dic = new Dictionary<char, char>();
            dic.Add(')', '(');
            dic.Add('}', '{');
            dic.Add(']', '[');
            foreach (var item in s)
            {
                if (dic.ContainsKey(item))
                {
                    if (ts.Count <= 0)
                    {
                        return false;
                    }

                    var left = ts.Pop();
                    if (left != dic[item])
                    {
                        return false;
                    }
                }
                else
                {
                    ts.Push(item);
                }
            }

            if (ts.Count > 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }
}
