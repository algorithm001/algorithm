class TrieNode {
public:
	bool isWord;
	TrieNode* children[26];
	TrieNode():isWord(false) {
		for (int i = 0; i < 26; i++)
		{
			children[i] = NULL;
		}
	}

	~TrieNode() {
		for (int i = 0; i < 26; i++)
		{
			if (children[i] != NULL) delete children[i];
		}
	}
};

class Solution {
public:
	string longestWord(vector<string>& words) {

		if (words.size() == 0) return "";

        //构建Trie树
		for (int i = 0; i < words.size(); i++)
		{
			addWord(words[i]);
		}

		string ret = "";
		result = "";

        //使用Trie树深度优先遍历查找出最长的单词
		findLongestWord(root, ret);

		return result;
	}

	void addWord(string& word)
	{
		if (root == NULL) root = new TrieNode();
        TrieNode* ptr = root;

		for (char ch : word)
		{
			if(ptr->children[ch - 'a'] == NULL) ptr->children[ch - 'a'] = new TrieNode();

			ptr = ptr->children[ch - 'a'];

		}

		ptr->isWord = true;
	}

	void findLongestWord(TrieNode* root, string str) {
		if (root != NULL)
		{
			for (int i = 0; i < 26; i++)
			{
				if (root->children[i] != NULL && root->children[i]->isWord == true)
				{
					string newStr = str + (char)('a' + i);
					if (newStr.size() > result.size()) {
						result = newStr;
					}
					findLongestWord(root->children[i], newStr);
				}
			}
		}
	}

private:
	TrieNode * root;
	string result;
	int longestLength;
};
