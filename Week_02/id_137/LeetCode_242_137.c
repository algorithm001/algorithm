/*
 * "https://leetcode-cn.com/problems/arranging-coins/"
 * "Author : Shaodong Song"
 * "Date : 2019-04-20"
 */

/*
 * 242 - Valid Anagram.
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 */

#include<stdio.h>
#include<string.h>

#define false     0
#define true      1
#define MAX_CHAR  256

int isAnagram(char* s, char* t) {

    signed int hash_table[MAX_CHAR];
    memset(hash_table, -1, sizeof(hash_table));

    if (s == NULL || t == NULL) {
        return false;
    }

    if (strlen(s) != strlen(t)) {
        return false;
    }

    char *p = s;
    while(*p != '\0') {
        hash_table[*p]++;
        p++;
    }

    p = t;
    while(*p != '\0') {
        if (hash_table[*p] >= 0) {
            hash_table[*p]--;   
        } else {
            return false;
        }
        p++;
    }

    return true;
}

int main(int argc, char** argv) {

    char s[] = "anagram";
    char t[] = "nagaram";

    printf(" '%s' is an '%s' of valid anagram : %s \n", t, s, 
            isAnagram(s, t) ? "true" : "false");


    char s1[] = "rat";
    char t1[] = "car";

    printf(" '%s' is an '%s' of valid anagram : %s \n", t1, s1, 
            isAnagram(s1, t1) ? "true" : "false");

    return 0;
}
