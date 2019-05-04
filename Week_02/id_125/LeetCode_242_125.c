bool isAnagram(char* s, char* t) {
    #define SIZE 26
    int a[SIZE], b[SIZE];
    memset(a, 0, SIZE*sizeof(int));
    memset(b, 0, SIZE*sizeof(int));

    while(*s) {
        a[*s - 'a']++;
        s++;
    }
    while(*t) {
        b[*t - 'a']++;
        t++;
    }
    return memcmp(a, b, SIZE*sizeof(int)) == 0;
}
