    public int[] sortArrayByParityII(int[] array) {
        int[] temp = new int[array.length];
        int t = 0;
        int a = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                temp[t] = array[i];
                t += 2;
            } else {
                temp[a] = array[i];
                a += 2;
            }
        }
        return temp;

    }
