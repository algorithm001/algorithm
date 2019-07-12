class TrieNode {
public:
	bool wordEnd;
	vector<TrieNode*> children;
    TrieNode():wordEnd(false),children(26, nullptr) {}
    TrieNode(vector<string>& words):wordEnd(false),children(26, nullptr) {
        addWords(words); 
    }
	~TrieNode() {
		for (TrieNode* child : children)
			if (child) delete child;
	}
    
    void addWords(vector<string>& words){
        for (auto &word : words) {
            TrieNode *ptr = this;
			for (auto ch : word) {
			    if (ptr->children[ch - 'a'] == NULL) {
				    ptr->children[ch - 'a'] = new TrieNode();
			    }
			    ptr = ptr->children[ch - 'a'];
		    }
		    ptr->wordEnd = true;//标记为单词
		}
    }
};

class Solution {
public:
	string resStr = "";
	string longestWord(vector<string>& words) {
        string start = "";
		findWord(new TrieNode(words), start);
        return resStr;
	}

    void findWord(TrieNode *root, string &resWord) {
		if (root == nullptr) {
            return;
        }
		for (int index = 0; index < 26; ++index) {
            if (root->children[index] ==nullptr){
                continue;
            }
			if (root->children[index]->wordEnd) {
				string newStr = resWord + char('a' + index);
				if (newStr.size() > resStr.size()) {
					resStr = newStr;
				}
				findWord(root->children[index], newStr);
			}
		}
	}
};
