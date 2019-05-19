class Solution {
    public String longestWord(String[] words) {
        Trie trie=new Trie();
        for(String word:words){
            trie.save(word);
        }
        
        //遍历树结构 找到树的叶子节点 求此叶子节点长度 取最大 
        searchLongestWord(new StringBuilder(),trie.children);
        return longestWord;
    }
    
    String longestWord="";
    
    private void searchLongestWord(StringBuilder sb,Node[] children){
        if(children==null){
            return;
        }
        for(Node node:children){
            if(node!=null && node.isEnd){
                sb.append(node.val);
                if(sb.length()>longestWord.length()){
                    longestWord=sb.toString();
                }
                searchLongestWord(sb,node.children);
                sb.deleteCharAt(sb.length()-1);
            }
            
            
        }
    }
   
    
    
    
    
    
    
    class  Node{
        
        public char  val;
        public Boolean isEnd;
        public Node[] children;
        
        public Node(char val){
            this.val=val;
            isEnd=false;
            children=new Node[26];
        }
        
        public void setIsEnd(boolean isEnd){
            this.isEnd=isEnd;
        }
        
        
    }
    
    
    /**
    *前缀树 
    */
    class Trie{
        
        Node[] children;
        
        public Trie(){
            children=new Node[26];
        }
        
        public void save(String word){
            if(word==null || word.length()==0){
                return ;
            }
            insert(0,word.toCharArray(),children);
        }
        
        
        public void insert(int l,char[] chars,Node[] children){
            int i=chars[l]-'a';
            if(children[i]==null){
                children[i]=new Node(chars[l]);
            }
            if(l==(chars.length-1)){
                children[i].setIsEnd(true);
                return;
            }
            
            if(children[i].children==null){
                children[i].children=new Node[26];
            }
            insert(l+1,chars,children[i].children);
        
        }
        
        public boolean find(String word){
            char[] chars=word.toCharArray();
            Node[] childs=children;
            boolean result=false;
            for(char c:chars){
                int index=c-'a';
                if(childs[index]==null){
                    return result;
                }
                  result=childs[index].isEnd;
                childs=childs[index].children;
              
            }
          
            return result;
        }
                     
        
    }
    
    
    
}