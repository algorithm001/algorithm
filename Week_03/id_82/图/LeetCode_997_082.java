static int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1)   return -1;
        int[] people = new int[N];
        List<Integer> judge = new LinkedList<>();
        for (int i = 0; i < people.length; i++){
            people[i] = i;
        }   //initialization
        for (int i = 0; i < trust.length; i++){
            people[trust[i][0] - 1] = -1;
        }
        for (int i = 0; i < people.length; i++){
            if (people[i] != -1)    judge.add(people[i]);
        }
        if (judge.size() != 1)  return -1;  //JC:judge contains one element.

        for (int i = 0; i < people.length; i++){
            people[i] = i;
        }   //initialization
        for (int i = 0; i < trust.length; i++){
            if (trust[i][1] == judge.get(0) + 1)    people[trust[i][0] - 1] = -1;
        }
        int count = 0;
        for (int i = 0; i < people.length; i++){
            if (people[i] == -1)    count++;
        }
        if (count == N-1)   return judge.get(0) + 1;
        else return -1;
    }