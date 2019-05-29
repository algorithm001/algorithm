    public int[] sortArrayByParity(int[] array) {
        //维持一个新数组
        int[] temp = new int[array.length];
        int ouIndex = 0;
        int jiIndex = array.length - 1;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 0) {
                temp[ouIndex] = array[i];
                ++ouIndex;
            } else {
                temp[jiIndex] = array[i];
                --jiIndex;
            }
        }
        return temp;
    }
        
