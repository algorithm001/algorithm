public class MedianFinder
    {
        List<int> numberList;
        /** initialize your data structure here. */
        public MedianFinder()
        {
            numberList = new List<int>();
        }

        public void AddNum(int num)
        {
            int index = 0;
            if (numberList.Count == 0)
            {
                numberList.Add(num);
                return;
            }
            if (num >= numberList[numberList.Count / 2])
            {
                index = numberList.Count / 2;
            }
            while (index < numberList.Count)
            {
                if (numberList[index] >= num)
                {
                    numberList.Insert(index, num);
                    return;
                }
                index++;
            }
            numberList.Add(num);
        }


        public double FindMedian()
        {
            if(numberList.Count==0)
            {
                return 0;
            }else
            {
                if(numberList.Count%2==1)
                {
                    return numberList[numberList.Count / 2];
                }else
                {
                    return (numberList[numberList.Count / 2 - 1]+ numberList[numberList.Count / 2])/(double)2;
                }
            }
        }
    }
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.AddNum(num);
 * double param_2 = obj.FindMedian();
 */
