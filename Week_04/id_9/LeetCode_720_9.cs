using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProblemSolutions
{
    public class Problem720 : IProblem
    {
        public void RunProblem()
        {
            string[] words = new string[] { "a", "apple", "b", "be", "bee", "beer" };
            var temp = LongestWord(words);
        }

        public string LongestWord(string[] words)
        {
            /*
             * 实现思路：
             * 1.使用数据源来“喂养”TrieTree
             * 2.再让TrieTree告知我们，满足题目需求的结果
             * 
             * 时间复杂度：输入的单词，是要遍历一次的，构建trieTree，然后要拿到结果，还是要做回溯的，那么是对树所有节点又遍历一次
             * 空间复杂度：主要是TrieTree占用的存储空间
             * 
             * 使用此种方式，其实就是数据源越大越是有利
             */

            var trieTree = new TrieTree();

            foreach (var wordItem in words)
                trieTree.AddWord(wordItem);

            return trieTree.GetLongestWord();
        }

        public class TrieTree
        {
            public class TrieNode
            {
                public string m_words;
                public TrieNode[] m_nextIndex = new TrieNode[26];
                public bool m_isWord;
            }

            private TrieNode m_rootNode = new TrieNode();

            public void AddWord(string word)
            {
                var trieNodeTemp = m_rootNode;
                foreach (var wordItem in word)
                {
                    var intTemp = wordItem - 'a';

                    if (trieNodeTemp.m_nextIndex[intTemp] == null)
                        trieNodeTemp.m_nextIndex[intTemp] = new TrieNode();

                    trieNodeTemp = trieNodeTemp.m_nextIndex[intTemp];
                }
                trieNodeTemp.m_isWord = true;
                trieNodeTemp.m_words = word;
            }

            public string GetLongestWord()
            {
                Recursive(m_rootNode, -1);
                return longestWord;
            }

            private int longest = 0;
            private string longestWord = "";
            private void Recursive(TrieNode node, int length)
            {
                length++;

                if (node.m_isWord && length > longest)
                {
                    longest = length;
                    longestWord = node.m_words;
                }

                for (int i = 0; i < node.m_nextIndex.Length; i++)
                {
                    if (node.m_nextIndex[i] != null && node.m_nextIndex[i].m_isWord)
                    {
                        Recursive(node.m_nextIndex[i], length);
                    }
                }
            }
        }

        public string LongestWord1(string[] words)
        {
            /*
             * 思路：
             * 1.结果要求按照字典序来处理相同长度的单词，那么就先对数组做字典序排序，复杂度：O(nlogn);
             * 2.遍历新的数组，寻找满足条件的最长单词
             * 
             * 时间复杂度：O(nlogn + n)，但是还要考虑到字符串比较的复杂度才行，字符串比较，应该是使用简单的比较方法才对
             * 空间复杂度：O(n)，因为会把所有的单词存入到set中去
             */

            var forReturn = "";
            HashSet<string> sets = new HashSet<string>();

            var sortedArray = words.OrderBy(i => i);

            foreach (var arrayItem in sortedArray)
            {
                if (arrayItem.Length == 1 || sets.Contains(arrayItem.Substring(0, arrayItem.Length - 1)))
                {
                    if (forReturn.Length < arrayItem.Length)
                        forReturn = arrayItem;

                    sets.Add(arrayItem);
                }
            }

            return forReturn;
        }
    }
}
