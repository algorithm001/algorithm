
class Solution {

    /**
     *  Medium
     *  692. Top K Frequent Words
     *  https://leetcode.com/problems/top-k-frequent-words/
     *
     * Given a non-empty list of words, return the k most frequent elements.
     *
     * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
     * then the word with the lower alphabetical order comes first.
     *
     * Example 1:
     * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * Output: ["i", "love"]
     * Explanation: "i" and "love" are the two most frequent words.
     *     Note that "i" comes before "love" due to a lower alphabetical order.
     *
     * Example 2:
     * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * Output: ["the", "is", "sunny", "day"]
     * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
     *     with the number of occurrence being 4, 3, 2 and 1 respectively.
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Input words contain only lowercase letters.
     * Follow up:
     * Try to solve it in O(n log k) time and O(n) extra space.
     *
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(!map.containsKey(word)) {
                map.put(word, 1);
            }else {
                int t = map.get(word) + 1;
                map.put(word, t);
            }
        }
        List<String> list = new ArrayList<>(map.size());

        ListNode node = null;
        for(Map.Entry<String, Integer> set : map.entrySet()) {
            //System.err.println(String.format(" %s %s", set.getKey(), set.getValue()));
            if(node == null) {
                node = new ListNode(set.getValue(), set.getKey());
                continue;
            }

            node = insertNode(node, set.getValue(), set.getKey());

        }

        while (node != null) {
            list.add( node.s);
            if(list.size() == k) break;
            node = node.next;
        }

        //System.out.println(StringUtils.join(list, " - "));

        return list;
    }

    private ListNode insertNode(ListNode head, int time, String val) {

        if(time > head.time) {
            ListNode newHead = new ListNode(time, val);
            newHead.next = head;
            return newHead;
        }else if ( time < head.time) {
            ListNode nextHead = head.next;
            if(nextHead == null) {
                head.next = new ListNode(time, val);
            }else {
                head.next = insertNode(nextHead, time, val);
            }
            return head;
        }else {
            if(head.s.compareTo(val) > 0) {
                ListNode newHead = new ListNode(time, val);
                newHead.next = head;
                return newHead;
            }else {
                ListNode nextHead = head.next;
                if(nextHead == null) {
                    head.next = new ListNode(time, val);
                }else {
                    head.next = insertNode(nextHead, time, val);
                }
                return head;
            }
        }

    }

    public class ListNode {
        int time;
        String s ;

        ListNode next;
        ListNode(int time, String s) {
            this.time = time;
            this.s = s;
        }
    }
}