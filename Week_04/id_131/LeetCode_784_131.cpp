/*
  784. 字母大小写全排列
  给定一个字符串S，通过将字符串S中的每个字母转变大小写，
  我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
  
示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

*/
class Solution {
public:
    vector<string> letterCasePermutation(string S) {
        vector<string> resV;
        for(string::iterator iter = S.begin(); iter != S.end(); ++iter)
        {
            if(isdigit(*iter) != 0) // 是数字
            {
                for(vector<string>::iterator itV = resV.begin(); itV != resV.end(); ++itV)
                {
                    *itV += *iter;
                }
                if(resV.empty()) 
                {
                    string tmp(1, *iter);
                    resV.push_back(tmp);
                }
            }
            else
            {
                vector<string> tmpV = resV;
                for(vector<string>::iterator itV = resV.begin(); itV != resV.end(); ++itV)
                {
                    *itV += tolower(*iter);
                }
                for(vector<string>::iterator itmpV = tmpV.begin(); itmpV != tmpV.end(); ++itmpV)
                {
                    *itmpV += toupper(*iter);
                }
                
                resV.insert(resV.end(),tmpV.begin(),tmpV.end());
                
                if(resV.empty())
                {
                    string tmpLower(1, tolower(*iter));
                    string tmpupper(1, toupper(*iter));
                    resV.push_back(tmpLower);
                    resV.push_back(tmpupper);
                }
            }
            
        }
        
        return resV;
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