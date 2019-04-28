bool isAnagram(char* s, char* t) {
    int lens = strlen(s);
    int lent = strlen(t);
    if (lens != lent) return false;
    int flag[26] = {0};
    for (int i = 0; i < lens; i++){
        flag[s[i] - 'a']++;
    }
    for (int i = 0; i < lent; i++){
        if (flag[t[i] - 'a'] == 0) return false;
        flag[t[i] - 'a']--;
    }
    return true;
}
//4MS