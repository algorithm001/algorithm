/*
  720.词典中最长的单词
  给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，
  该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，
  则返回答案中字典序最小的单词。
  
  若无答案，则返回空字符串。

示例 1:
输入: 
words = ["w","wo","wor","worl", "world"]
输出: "world"
解释: 
单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。

示例 2:
输入: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出: "apple"
解释: 
"apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。

*/

/*
  思路 1 ：
  我们首先按照字典升序排序 words，并且新建 set 用于保存有顺序关系的 单词
  然后从前往后扫描words，如果 word 的长度 == 1，或者word的前 wordSize - 1
  组成的单词是由 words 词典中其他单词逐步添加一个字母组成的单词时，则加入set中
*/
class Solution {
public:
    string longestWord(vector<string>& words) {
        string ret = "";
        set<string> wordsSet; // 用于保存有顺序关系的 单词
        sort(words.begin(), words.end()); // 升序排序
        for(auto &word : words)
        {
            if( (word.size() == 1) 
               || (wordsSet.find(word.substr(0,word.size()-1)) != wordsSet.end()) )
            {
                wordsSet.insert(word);
                if(word.size() > ret.size()) ret = word; // 已按顺序排列，当相同长度时，ret已被设为字符顺序较小的那个
            }
        }
        return ret;
    }
};

/*
  思路 2：
  前缀树
*/
//前缀树的程序表示
class TrieNode {
public:
	bool isWord;//当前节点为结尾是否是单词
	vector<TrieNode*> children;
	TrieNode() : isWord(false), children(26, nullptr) {}
	~TrieNode() {
		for (TrieNode* child : children)
			if (child) delete child;
	}
};

class Solution {
public:
	string resStr = "";//存储结果
	TrieNode *trieRoot;//构建的单词前缀树
	string longestWord(vector<string>& words) {
		trieRoot = new TrieNode();
		for (auto &word : words) {
			addWord(word);
		}
		string tempStr = "";
		myFind(trieRoot, tempStr);
		return resStr;
	}
	//在树中插入一个单词的方法实现
	void addWord(string &word) {
		TrieNode *ptr = trieRoot;//扫描这棵树，将word插入
		//将word的字符逐个插入
		for (auto ch : word) {
			if (ptr->children[ch - 'a'] == NULL) {
				ptr->children[ch - 'a'] = new TrieNode();
			}
			ptr = ptr->children[ch - 'a'];
		}
		ptr->isWord = true;//标记为单词
	}
	//扫描root，寻找最长的合法单词
	void myFind(TrieNode *root, string &resWord) {
		if (root != NULL) {
			//搜索它的二十六个指针
			for (int index = 0; index < 26; ++index) {
                //只有当这个子指针指向的字母是一个单词的尾端，以这个字母结尾的单词才能是一个合法的结果
				if (root->children[index] != NULL && root->children[index]->isWord) {
					string newStr = resWord + char('a' + index);
					if (newStr.size() > resStr.size()) {
						resStr = newStr;
					}
					myFind(root->children[index], newStr);
				}
			}
		}
	}
};