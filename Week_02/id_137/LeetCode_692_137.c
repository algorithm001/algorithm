/*
 * "https://leetcode-cn.com/problems/arranging-coins/"
 * "Author : Shaodong Song" 
 * "Date : 2019-04-20"
 */

/*
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency,
 * then the word with the lower alphabetical order comes first.
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    char word[50];
    int  freq;
} element;

static int
cmpstringp(const void *p1, const void *p2)
{
    element * e1 = (element *)p1;
    element * e2 = (element *)p2;
        
    if(e1->freq != e2->freq) {
        return (e2->freq - e1->freq);
    }
    
    return (strcmp(e1->word, e2->word));

}

char** topKFrequent(char** words, int wordsSize, int k, int* returnSize) {
    
    /** 
     *1、遍历所有单词记录每个单词出现的频率
     *2、创建一个数组保存这些单词和频率，借助 glibc 的 qsort 函数进行排序
     *3、填充要返回的单词数组并返回
     *4、cmp 对int类型进行排序的话，b - a 为降序，a - b 为升序
     */

    element *els = (element *)calloc(sizeof(element), wordsSize);
    
    int i = 0;
    int t = 0;
    int j = 0;
    
    strcpy(els[0].word, words[0]);
    els[0].freq = 1;
    t++;
    
    for (i = 1; i < wordsSize; i++) {
        for (j = 0; j < t; j++) {
            if (strcmp(els[j].word, words[i]) == 0) {
                (els[j].freq)++;
                break;
            }
        }
        
        if (j == t) {
            strcpy(els[t].word, words[i]);
            els[t].freq = 1;
            t++;
        }
    }
    
    qsort(els, t, sizeof(els[0]), cmpstringp);
        
    char ** res = (char**)malloc(sizeof(char*) * k);
    
    for (i = 0; i < k; i++) {
        res[i] = calloc(50, sizeof(char));
        strcpy(res[i], els[i].word);
    }
    
    *returnSize = k;
    
    return res;
}

int main(int argc, char** argv) {
    int i = 0;
    int uniq_words_count = 0;
    char* words[] = {"i", "love", "leetcode", "i", "love", "coding"};

    /* Unit Test 1 */
    int k = 2;
    char** uniq_words = topKFrequent(words, sizeof(words) / sizeof(char*), k,
                                    &uniq_words_count);    

    for (i = 0; i < uniq_words_count; i++) {
        printf("%s \t", uniq_words[i]);    
    }
    printf("\n");

    /* Unit Test 2 */
    k = 3;
    uniq_words = topKFrequent(words, sizeof(words) / sizeof(char*), k,
                                    &uniq_words_count);    

    for (i = 0; i < uniq_words_count; i++) {
        printf("%s \t", uniq_words[i]);    
    }
    printf("\n");

    return 0;
}
