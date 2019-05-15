

    // LeetCode 104

	
	// [ 2. Trie树 ]

    // 从最短的字符串开始建树，后面下一个，如果减1能找到，插入并记录为rst
    public String longestWord(String[] words) {
        Set<Integer> set = new TreeSet<>();
        HashMap<Integer, List<String>> map = new HashMap<>();
        TrieNode p = root;

        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            set.add(len);
            List<String> list = null;
            if (map.containsKey(len)){
                list = map.get(len);
            }else {
                list = new ArrayList<>();
            }
            list.add(words[i]);
            map.put(len, list);
        }

        // 去重，排序
        int[] wordsLen = new int[set.size()];
        int k = 0;
        for (Integer n : set) {
            wordsLen[k++] = n;
        }
        Arrays.sort(wordsLen);
        String rst = "";
        // 按word长度递增顺序，开始建trie树
        // 先用word去掉尾字符在trie树中查询，找到rst记录，并插入树
        for (int i = 0; i < wordsLen.length; i++) {
            int len = wordsLen[i];
            List<String> list = map.get(len);
            for (String word : list){
                char[] text = word.toCharArray();
                char[] txt = Arrays.copyOf(text, text.length-1);
                if (text.length > 1){
                    if (find(txt)){
                        insert(text);
                        if (rst.length() == word.length()){
                            if (rst.compareTo(word) > 0){
                                rst = word;
                            }
                        }else {
                            rst = word;
                        }
                    }
                }else {
                    if (rst.length() == 0){
                        rst = word;
                    }else if (rst.compareTo(word) > 0){
                        rst = word;
                    }
                    insert(text);
                }
            }
        }

        return rst;
    }

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

    // 插入一个字符
    public void insert(char[] text){
        TrieNode p = root;

        int len = text.length;
        for (int i = 0; i < len; i++) {
            // 字符插入位置索引
            int index = text[i] - 'a';
            // 根据索引插入children中。如果已经存在则不处理
            if (p.children[index] == null){
                p.children[index] = new TrieNode(text[i]);
            }
            // 到下一层遍历
            p = p.children[index];
        }
        p.isEndingChar = true;
    }


    // 查找一个字符串
    public boolean find(char[] pattern){
        TrieNode p = root;

        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null){
                return false;
            }
            // 继续向下一层查询
            p = p.children[index];
        }
        if (p.isEndingChar == false){
            return true;
        }

        return true;
    }


    
	
	
    // [ 1. 哈希表 ]

   
    // 通过单词长度递减，然后在words中查询，如果能找到，符合题目要求
    public String longestWord1(String[] words) {
        int[] wordsLen = new int[words.length];
        HashMap<String, Integer> map = new HashMap<>();
        TrieNode p = root;

        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            wordsLen[i] = len;
            if (!map.containsKey(words[i])){
                map.put(words[i], 1);
            }
        }

        String rst = "";
        for (int i = 0; i < words.length; i++) {
            String wd = words[i];
            int len = wd.length();
            int j = 0;
            for (j = 1; j < len; j++) {
                wd = wd.substring(0, len - j);
                // 子串在words中没有
                if (!map.containsKey(wd)){
                    break;
                }
            }
            if (j == len){
                if (rst.length() == 0 || rst.length() < len){
                    rst = words[i];
                }else if (rst.length() == len && rst.compareTo(words[i]) > 0){
                    rst = words[i];
                }
            }
        }
        return rst;
    }