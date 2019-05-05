public class Solution {
    public IList<string> TopKFrequent(string[] words, int k) {
            int[] wordsTimes = new int[words.Length];
            for(int i=words.Length-1;i>=0;i--)
            {
                for(int j=0;j<i;j++)
                {
                    if(words[j]==words[i])
                    {
                        wordsTimes[j] ++;
                        wordsTimes[i] --;
                        break;
                    }
                }
                wordsTimes[i]++;
            }
            List<int> indexer = new List<int>();

            while(k>0)
            {
                int index = -1;
                int maxValue = 0;
                for(int i=0;i<wordsTimes.Length;i++)
                {
                    if(wordsTimes[i]>maxValue)
                    {
                        maxValue = wordsTimes[i];
                        index = i;
                        //wordsTimes[i] = 0;
                    }else if(index>=0&&wordsTimes[i]== maxValue&&string.Compare(words[index],words[i])>0)
                    {
                        maxValue = wordsTimes[i];
                        index = i;
                    }
                }

                if (index >= 0)
                {
                    wordsTimes[index] = 0;
                    indexer.Add(index);
                }
                k--;
            }
            IList<string> result = new List<string>();

            foreach(var item in indexer)
            {
                result.Add(words[item]);
            }
            return result;
    }
}
