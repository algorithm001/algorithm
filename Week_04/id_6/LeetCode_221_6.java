

    // LeetCode 309


    // [ 1. Trie树 + 回溯算法  ]

    class TrieNode {

        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data){
            this.data = data;
        }
    }

    // root
    TrieNode root = new TrieNode('\\');

    public void addWord(String word){
        char[] wd = word.toCharArray();

        TrieNode p = root;
        // 遍历单词，在Tire中查找
        for (int i = 0; i < wd.length; i++) {
            int index = wd[i] - 'a';
            // 字符不存在
            if (p.children[index] == null){
                p.children[index] = new TrieNode(wd[i]);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean search(String word){
        TrieNode p = root;

        return find(word, root);
    }


    // 先按前缀匹配在Trie树中查找
    // 遇到‘.’时，从该点children钟任意一个存在字符向下去匹配，dfs+回溯
    public boolean find(String word, TrieNode curr){
        TrieNode p = curr;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.'){
                // 从任何一个children[index]!=null 递归的去查找
                // 如果匹配失败，回溯到上一个点，继续
                for (int j = 0; j < p.children.length; j++) {
                    if (p.children[j] != null){
                        String wd = word.substring(i+1, word.length());
                        if (find(wd, p.children[j])){
                            return true;
                        }
                    }
                }
                return false;
            }else {
                int index = c - 'a';
                if (p.children[index] != null){
                    p = p.children[index];
                }else {
                    return false;
                }
            }

        }
        // 不是结尾
        if (!p.isEndingChar){
            return false;
        }

        return true;
    }