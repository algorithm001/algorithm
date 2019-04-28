package com.fanlu.leetcode.hashtable;
// Source : https://leetcode.com/problems/top-k-frequent-words/
// Id     : 692
// Author : Fanlu Hai
// Date   : 2018-04-23
// Other  : I used PriorityQueue which I suppose should be some other data structure implemented by myself.
// Tips   :

import java.util.*;

public class TopKFrequentWords {
    Map<String, Integer> countMap = new HashMap<>();

    //99.50%  89.29%
    public List<String> topKFrequent(String[] words, int k) {

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(words.length, new StringComparator());
        for (String word : countMap.keySet()) {
            queue.add(word);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }

        return list;
    }


    //99.50%  89.29%
    public List<String> topKFrequentOriginal(String[] words, int k) {

        for (String word : words) {
            if (countMap.containsKey(word)) {
                countMap.put(word, (countMap.get(word) + 1));
            } else {
                countMap.put(word, 1);
            }
        }
        PriorityQueue<String> queue = new PriorityQueue<>(words.length, new StringComparator());
        for (String word : countMap.keySet()) {
            queue.add(word);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }

        return list;
    }


    //53.29% 100%
    public List<String> topKFrequentWithExperiment(String[] words, int k) {

        for (String word : words) {
            // if below code is used 53.29% 39.95%
//            if (countMap.containsKey(word)) {
//                countMap.put(word, (countMap.get(word) + 1));
//            } else {
//                countMap.put(word, 1);
//            }
            // use getOrDefault instead of code above
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

//        PriorityQueue<String> queue = new PriorityQueue<>(words.length, new StringComparator());

        // use lambda instead of inner class
        // it seems lambda can save some space but also slow down the program.
        PriorityQueue<String> queue = new PriorityQueue<String>(
                (w1, w2) -> countMap.get(w1).equals(countMap.get(w2)) ?
                        w1.compareTo(w2) : countMap.get(w2) - countMap.get(w1));
        for (String word : countMap.keySet()) {
            queue.add(word);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }

        return list;
    }


    class StringComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            if (countMap.get(s1) < countMap.get(s2))
                return 1;
            else if (countMap.get(s1) > countMap.get(s2))
                return -1;
            return s1.compareTo(s2);
        }
    }

    public static void main(String[] args) {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        String[] list = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> result = topKFrequentWords.topKFrequent(list, 2);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
