class Solution {

    class WordFreq {
		String word;
		Integer freq;

		@Override
		public String toString() {
			return "WordFreq [word=" + word + ", freq=" + freq + "]";
		}

		public WordFreq(String word, Integer freq) {
			super();
			this.word = word;
			this.freq = freq;
		}

	}


    public List<String> topKFrequent(String[] words, int k) {


		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (String s : words) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		TreeSet<WordFreq> set = new TreeSet<WordFreq>(new Comparator<WordFreq>() {
			@Override
			public int compare(WordFreq o1, WordFreq o2) {
				if (o1.freq == o2.freq) {
					return o1.word.compareTo(o2.word);
				} else {
					return o2.freq - o1.freq;
				}

			}
		});

		for (String key : map.keySet()) {
			set.add(new WordFreq(key, map.get(key)));
		}

		List<String> result = new ArrayList<String>();
		for (WordFreq key : set) {
			if (k-- == 0)
				break;
			result.add(key.word);
		}

		return result;


    }
}
