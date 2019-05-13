using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProblemSolutions
{
    public class Problem211 : IProblem
    {
        public void RunProblem()
        {
            WordDictionary obj = new WordDictionary();
            obj.AddWord("bad");
            obj.AddWord("dad");
            obj.AddWord("mad");
            bool param_2 = obj.Search("pad");
            param_2 = obj.Search("bad");
            param_2 = obj.Search(".ad");
            param_2 = obj.Search("b..");
            param_2 = obj.Search("b.d");
        }

        public class WordDictionary
        {
            public class TrieNode
            {
                public TrieNode(char c)
                {
                    m_char = c;
                }
                public char m_char;
                public bool m_isWord;
                public TrieNode[] m_nextNode = new TrieNode[26];
            }

            private TrieNode rootNode = new TrieNode('\\');

            /** Initialize your data structure here. */
            public WordDictionary()
            {

            }

            /** Adds a word into the data structure. */
            public void AddWord(string word)
            {
                var nodeTemp = rootNode;
                foreach (var wordItem in word)
                {
                    var charIndex = wordItem - 'a';
                    if (nodeTemp.m_nextNode[charIndex] == null)
                        nodeTemp.m_nextNode[charIndex] = new TrieNode(wordItem);

                    nodeTemp = nodeTemp.m_nextNode[charIndex];
                }
                nodeTemp.m_isWord = true;
            }

            /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
            public bool Search(string word)
            {
                return RecurSive(rootNode, word, -1);
            }

            private bool RecurSive(TrieNode node, string word, int charIndex)
            {
                //查看当前节点满足的条件
                if (charIndex > word.Length - 1) return false;
                if (charIndex == word.Length - 1) return node.m_isWord && (node.m_char == word[charIndex] || word[charIndex] == '.');

                //查看下一个节点满足的条件
                var curChar = word[charIndex + 1];
                if (curChar == '.')
                {
                    foreach (var nodeItem in node.m_nextNode)
                    {
                        var isOk = false;
                        if (nodeItem != null)
                            isOk = RecurSive(nodeItem, word, charIndex + 1);

                        if (isOk) return true;
                    }
                }
                else
                {
                    var cIndex = curChar - 'a';
                    if (node.m_nextNode[cIndex] != null)
                        return RecurSive(node.m_nextNode[cIndex], word, charIndex + 1);
                }

                return false;
            }
        }

        /**
         * Your WordDictionary object will be instantiated and called as such:
         * WordDictionary obj = new WordDictionary();
         * obj.AddWord(word);
         * bool param_2 = obj.Search(word);
         */
    }
}
