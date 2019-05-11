#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
struct strCnt {
    char *str;
    int cnt;
};

void insertWord(struct strCnt **sc, int *s, char* w) {
    int i;
    struct strCnt tmp;
    int cmp;
    if (!*sc) {
        *sc = (struct strCnt*)malloc(sizeof(struct strCnt));
        (*sc)[0].str = w;
        (*sc)[0].cnt = 1;
        *s = 1;
    } else {
        for (i = 0; i < *s; i++) {
            if (!strcmp((*sc)[i].str, w)) {
                (*sc)[i].cnt++;
                break;
            }
        }
        if (i == *s) {
            (*s)++;
            *sc = (struct strCnt*)realloc(*sc, sizeof(struct strCnt) * (*s));
            (*sc)[*s - 1].str = w;
            (*sc)[*s - 1].cnt = 1;
        }
    }
}

void sortWords(struct strCnt *sc, int size) {
    int i, j;
    struct strCnt tmp;
    for (i = 0; i < size; i++) {
        for (j = 0; j < size - i - 1; j++) {
            if(strcmp(sc[j].str, sc[j + 1].str) > 0) {
                memcpy(&tmp, &sc[j], sizeof(struct strCnt));
                memcpy(&sc[j], &sc[j + 1], sizeof(struct strCnt));
                memcpy(&sc[j + 1], &tmp, sizeof(struct strCnt));
            }
        }
    }
    for (i = 0; i < size; i++) {
        for (j = 0; j < size - i - 1; j++) {
            if(sc[j].cnt < sc[j + 1].cnt) {
                memcpy(&tmp, &sc[j], sizeof(struct strCnt));
                memcpy(&sc[j], &sc[j + 1], sizeof(struct strCnt));
                memcpy(&sc[j + 1], &tmp, sizeof(struct strCnt));
            }
        }
    }
}

char** topKFrequent(char** words, int wordsSize, int k, int* returnSize) {
    int i;
    struct strCnt *sc = NULL;
    int size = 0;
    char** result;

    for (i = 0; i < wordsSize; i++) {
        insertWord(&sc, &size, words[i]);
    }
    for (i = 0; i < size; i++) {
        printf("%d: %d, %s\n", i, sc[i].cnt, sc[i].str);
    }
    sortWords(sc, size);
    for (i = 0; i < size; i++) {
        printf("%d: %d, %s\n", i, sc[i].cnt, sc[i].str);
    }
    result = (char**)malloc(sizeof(char*) * k);
    for (i = 0; i < k; i++) {
        result[i] = strdup(sc[i].str);
        printf("%d: %s\n", i, result[i]);
    }
    return result;
}

//"i", "love", "leetcode", "i", "love", "coding"
int main(int argc, char* argv[])
{
	int size;
	char **words;
	int k;
	int ret;
	int i;

	if (argc < 3) return 0;

	size = atoi(argv[1]);
	words = (char**)malloc(sizeof(char*)*size);
	for (i = 0; i < size; i++) {
		*(words + i) = strdup(argv[i + 2]);
		printf("%s\n", *(words + i));
	}
    k = atoi(argv[size + 2]);
    printf("%d\n", k);
	topKFrequent(words, size, k, &ret);
}
