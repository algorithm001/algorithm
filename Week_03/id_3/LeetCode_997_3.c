int findJudge(int N, int** trust, int trustSize, int* trustColSize){
    int loop;
    int row;
    int col;
    int rowArr[N+1];
    int colArr[N+1];
    
    if(1 == N){
        return N;
    }
    
    memset(rowArr, 0, sizeof(int) * (N+1));
    memset(colArr, 0, sizeof(int) * (N+1));

    for(loop = 0; loop < trustSize; loop++){
        row = trust[loop][0];
        col = trust[loop][1];
        colArr[col] += 1;
        rowArr[row] += 1;
    }

    for(loop = 1; loop < N+1; loop++){
        if(N-1 == colArr[loop] && 0 == rowArr[loop]){
            return loop;
        }
    }
    return -1;
}