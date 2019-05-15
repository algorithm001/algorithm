class Solution {
    public List<String> topKFrequent(String[] words, int k) {

     List<String> list = new ArrayList<String>(k);
     if(k<1){
         return list;
     }
    //字母顺序排序
    margeSort(words,0,words.length-1);
    Node[] arr = new Node[words.length];
    int index = 0;
    String pointer = words[0];        
    arr[0] = new Node(pointer,1);
        
    for(int i=1 ;i<words.length;i++){
        if(pointer.equals(words[i])){
            arr[index].count ++;
            continue;
        }else{
          pointer = words[i];
          arr[++index] = new Node(pointer,1);
          pointer = words[i]; 
        }  
    }
    // 出现频率排序
    margeSort(arr,0,index);
    for(int i= 0 ;i < k ;i++ ){
        list.add(arr[i].key);
    }

    return list;     
        
    }
    
    
    public  void margeSort(Comparable[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int mid = left +((right - left) >> 1);
        margeSort(arr,left,mid);
        margeSort(arr,mid+1,right);
        margeSortArr(arr,left,mid,mid+1,right);
    }

    public void margeSortArr(Comparable[] arr,int leftStart , int leftEnd ,int rightStart, int rightEnd){
        //临时数组长度计算
        int len = rightEnd - leftStart + 1;
        Comparable[] tmpArr = new Comparable[len];
        int i = 0, l = leftStart, r = rightStart;
        while (i < len) {
            if (l <= leftEnd && r <= rightEnd) {
                if (arr[l] .compareTo(arr[r]) > 0) {
                    tmpArr[i] = arr[r];
                    r++;
                } else {
                    tmpArr[i] = arr[l];
                    l++;
                }
            } else if (l <= leftEnd) {
                //左边数组直接添加到临时数组尾部
                tmpArr[i] = arr[l];
                l++;
            } else{
                //右边数组直接添加到临时数组尾部
                tmpArr[i] = arr[r];
                r++;
            }
            i++;

        }
        //数据迁移
        i = 0;
        for (int j = leftStart; j <= leftEnd; j++) {
            arr[j] = tmpArr[i];
            i++;
        }

        for (int k = rightStart; k <= rightEnd; k++) {
            arr[k] = tmpArr[i];
            i++;
        }
    }
}

    class Node implements Comparable<Node>{
        String key;
        int count;

        public Node(String key, int count) {
            this.key = key;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return o.count - count;
        }
    }