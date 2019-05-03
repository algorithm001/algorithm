import org.junit.Test;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/03
 */
public class LeetCode_895_108 {

    class FreqStack {

        private PriorityQueue<Pair> queue = null;
        private HashMap<Integer, Integer> itemCountMap = null;
        private int count;

        public FreqStack() {
            itemCountMap = new HashMap<>();
            queue = new PriorityQueue<>((o1, o2) ->
                    o1.getCount().compareTo(o2.getCount()) == 0 ?
                            -o1.getOrder().compareTo(o2.getOrder()) : -o1.getCount().compareTo(o2.getCount()));
        }

        public void push(int x) {
            count ++;
            itemCountMap.put(x, itemCountMap.getOrDefault(x, 0) + 1);
            queue.offer(new Pair(x, count, itemCountMap.getOrDefault(x, 0) + 1));
        }

        public int pop() {
            Pair peek = queue.poll();
            int item = peek == null ? -1 : peek.item;
            Integer integer = itemCountMap.get(item);
            if(integer == 1){
                itemCountMap.remove(item);
            }else {
                itemCountMap.put(item, itemCountMap.get(item) - 1);
            }
            return item;
        }

        private class Pair {
            private int item;
            //添加入队的顺序
            private Integer order;
            //共有几个相同的元素
            private Integer count;

            public Pair(int item, Integer order, Integer count) {
                this.item = item;
                this.order = order;
                this.count = count;
            }

            public int getItem() {
                return item;
            }

            public void setItem(int item) {
                this.item = item;
            }

            public Integer getOrder() {
                return order;
            }

            public void setOrder(Integer order) {
                this.order = order;
            }

            public Integer getCount() {
                return count;
            }

            public void setCount(Integer count) {
                this.count = count;
            }
        }
    }

}
