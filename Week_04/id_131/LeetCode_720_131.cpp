/*
  720.�ʵ�����ĵ���
  ����һ���ַ�������words��ɵ�һ��Ӣ��ʵ䡣�����ҳ����һ�����ʣ�
  �õ�������words�ʵ����������������һ����ĸ��ɡ��������ж�����еĴ𰸣�
  �򷵻ش����ֵ�����С�ĵ��ʡ�
  
  ���޴𰸣��򷵻ؿ��ַ�����

ʾ�� 1:
����: 
words = ["w","wo","wor","worl", "world"]
���: "world"
����: 
����"world"����"w", "wo", "wor", �� "worl"���һ����ĸ��ɡ�

ʾ�� 2:
����: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
���: "apple"
����: 
"apply"��"apple"�����ɴʵ��еĵ�����ɡ�����"apple"���ֵ���С��"apply"��

*/

/*
  ˼· 1 ��
  �������Ȱ����ֵ��������� words�������½� set ���ڱ�����˳���ϵ�� ����
  Ȼ���ǰ����ɨ��words����� word �ĳ��� == 1������word��ǰ wordSize - 1
  ��ɵĵ������� words �ʵ����������������һ����ĸ��ɵĵ���ʱ�������set��
*/
class Solution {
public:
    string longestWord(vector<string>& words) {
        string ret = "";
        set<string> wordsSet; // ���ڱ�����˳���ϵ�� ����
        sort(words.begin(), words.end()); // ��������
        for(auto &word : words)
        {
            if( (word.size() == 1) 
               || (wordsSet.find(word.substr(0,word.size()-1)) != wordsSet.end()) )
            {
                wordsSet.insert(word);
                if(word.size() > ret.size()) ret = word; // �Ѱ�˳�����У�����ͬ����ʱ��ret�ѱ���Ϊ�ַ�˳���С���Ǹ�
            }
        }
        return ret;
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