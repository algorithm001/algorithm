// https://leetcode-cn.com/problems/top-k-frequent-words/submissions/
// 692.前k个高频单词
// 这是拿到题目后的最快想出来的思路。晚点再想想有没有别的做法。
class Solution {
    class LinkNode{
        String val;
        LinkNode next;
        LinkNode(String s){
            val = s;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result_list = new LinkedList();
        
        // 1. 统计词频表和最大词频出现次数
        Map<String,Integer> frequency_map = new HashMap();// 词频表：key：单词，value：单词出现次数。
        int most_frequent = 0;
        
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(frequency_map.containsKey(word)){
                frequency_map.put(word,frequency_map.get(word)+1);
            }else{
                frequency_map.put(word,1);
            }
            most_frequent = Math.max(frequency_map.get(word),most_frequent);
        }
        
        // 2. 生成哈希表：下标 i 表示出现次数，值是出现 i 次的单词列表（这里是用链表表示的，字典序有序，初始为null）
        LinkNode[] frequency_list = new LinkNode[most_frequent+1];
        for (String key : frequency_map.keySet()) {
            int frequent = frequency_map.get(key);
            frequency_list[frequent] = build(frequency_list[frequent],key);
        }
        
        // 3. 逆序扫描哈希表，总共输出k个单词
        for(int i=most_frequent;i>=0;i--){
            LinkNode link = frequency_list[i];
            if(link==null){
                continue;
            }
            while(k!=0 && link!=null){
                result_list.add(link.val);
                k--;
                link = link.next;
            }
        }
        
        // 4. 这就是k个单词了
        return result_list;
    }
    
    //-------------------------------------------

    // 新节点插入链表，字典序有序。
    LinkNode build(LinkNode head,String s){
        // 如果原始链表为空，则直接 new 一个节点回去
        if(head==null){
            return new LinkNode(s);
        }
        
        // 否则的话，要找到合适的位置插入
        LinkNode tmp = new LinkNode(s);
        
        // 若s应该在头结点前面，即 s > head.val
        // System.out.println("---单词比较，s="+s+" head="+head.val+" 左侧比较小？"+leftIsSmaller(s,head.val));
        if(leftIsSmaller(s,head.val)){
            tmp.next = head;
            head = tmp;
            return head;
        }
        
        // 否则，s应该再头结点后面。then：
        LinkNode pre = head;
        LinkNode current = head.next;
        while(current!=null){
            // System.out.println("---单词比较，s="+s+" head="+current.val+" 左侧比较小？"+leftIsSmaller(s,current.val));
            if(leftIsSmaller(s,current.val)){
                // s应该在 current 前面
                pre.next = tmp;
                tmp.next = current;
                return head;
            }
            pre = pre.next;
            current = current.next;
        }
        
        // 如果在中间没找到，那就是直接插到结尾
        pre.next = tmp;
        return head;
        
    }

    
    //-------------------------------------------

    
    // 手动撸了一个字典序排序。。。心累。。。
    boolean leftIsSmaller(String x,String y){
        int i=0;
        while(i<x.length() && i<y.length()){
            int xc = x.charAt(i);
            int yc = y.charAt(i);
            if(xc==yc){
                i++;
                continue;// 注意啊，这里不能退出，得去比较下一个
            }else if(xc<yc){
                return true;
            }else{
                return false;
            }
        }
        // 注意，这里是 <=，不是 <
        if(x.length()<=i){
            return true;
        }else{
            return false;
        }
    }
    
    
    //-------------------------------------------
    // 请不要管我，我是 debug 用的
    //-------------------------------------------
        
    void print(Map<String,Integer> map){
        for (String key : map.keySet()) {
            System.out.println("单词-出现次数："+key+" - "+map.get(key));
        }
    }
    
    
    void print(LinkNode[] list){
        for(int i=0;i<list.length;i++){
            System.out.print("- "+i+"：");
            LinkNode tmp = list[i];
            while(tmp!=null){
                System.out.print("->"+tmp.val);
                tmp = tmp.next;
            }
            System.out.println();
        }
    }
    
    void print(LinkNode head){
        LinkNode tmp = head;
        while(tmp!=null){
            System.out.print("->"+tmp.val);
            tmp = tmp.next;
        }
        System.out.println();
    }
}
