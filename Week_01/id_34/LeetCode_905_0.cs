    public class Solution
    {
        public int[] SortArrayByParity(int[] A)
        {
            if (A == null && A.Length == 0)
            {
                return A;
            }
            int indexHead = 0;
            int indexTail = A.Length - 1;
            int tempValue = 0;
            while (indexHead < indexTail)
            {
                if (A[indexHead] % 2 == 1 && A[indexTail] % 2 == 0)
                {
                    tempValue = A[indexHead];
                    A[indexHead] = A[indexTail];
                    A[indexTail] = tempValue;
                    indexHead++;
                    indexTail--;
                }
                else if (A[indexHead] % 2 == 0 && A[indexTail] % 2 == 1)
                {
                    indexHead++;
                    indexTail--;
                }
                else if (A[indexHead] % 2 == 1)
                {
                    indexTail--;
                }
                else if (A[indexTail] % 2 == 0)
                {
                    indexHead++;
                }
            }
            return A;
        }
    }
