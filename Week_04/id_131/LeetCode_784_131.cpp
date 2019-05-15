/*
  784. ��ĸ��Сдȫ����
  ����һ���ַ���S��ͨ�����ַ���S�е�ÿ����ĸת���Сд��
  ���ǿ��Ի��һ���µ��ַ������������п��ܵõ����ַ������ϡ�
  
ʾ��:
����: S = "a1b2"
���: ["a1b2", "a1B2", "A1b2", "A1B2"]

*/
class Solution {
public:
    vector<string> letterCasePermutation(string S) {
        vector<string> resV;
        for(string::iterator iter = S.begin(); iter != S.end(); ++iter)
        {
            if(isdigit(*iter) != 0) // ������
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
  ˼· 2��
  ǰ׺��
*/
//ǰ׺���ĳ����ʾ
class TrieNode {
public:
	bool isWord;//��ǰ�ڵ�Ϊ��β�Ƿ��ǵ���
	vector<TrieNode*> children;
	TrieNode() : isWord(false), children(26, nullptr) {}
	~TrieNode() {
		for (TrieNode* child : children)
			if (child) delete child;
	}
};

class Solution {
public:
	string resStr = "";//�洢���
	TrieNode *trieRoot;//�����ĵ���ǰ׺��
	string longestWord(vector<string>& words) {
		trieRoot = new TrieNode();
		for (auto &word : words) {
			addWord(word);
		}
		string tempStr = "";
		myFind(trieRoot, tempStr);
		return resStr;
	}
	//�����в���һ�����ʵķ���ʵ��
	void addWord(string &word) {
		TrieNode *ptr = trieRoot;//ɨ�����������word����
		//��word���ַ��������
		for (auto ch : word) {
			if (ptr->children[ch - 'a'] == NULL) {
				ptr->children[ch - 'a'] = new TrieNode();
			}
			ptr = ptr->children[ch - 'a'];
		}
		ptr->isWord = true;//���Ϊ����
	}
	//ɨ��root��Ѱ����ĺϷ�����
	void myFind(TrieNode *root, string &resWord) {
		if (root != NULL) {
			//�������Ķ�ʮ����ָ��
			for (int index = 0; index < 26; ++index) {
                //ֻ�е������ָ��ָ�����ĸ��һ�����ʵ�β�ˣ��������ĸ��β�ĵ��ʲ�����һ���Ϸ��Ľ��
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