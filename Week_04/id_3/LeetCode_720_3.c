//所有字母均为小写字母

#define TRIE_MAX_LEN    26

typedef struct tnode{
    int val;
    struct tnode *pnext[TRIE_MAX_LEN];
}trienode;


void trieInsert(trienode *root, char *word, int wordlen){
    trienode *pCurrent = NULL;
    trienode *pNewNode = NULL;
    int loop;
    int i;
    int index;

    if(0 == wordlen){
        return;
    }

    pCurrent = root;
#if 1

    for(loop = 0; loop < wordlen; loop++){
        index = word[loop]-'a';

        if(NULL == (pCurrent->pnext)[index]){
            pNewNode = malloc(sizeof(trienode));
            pNewNode->val = 0;
            for(i = 0; i < TRIE_MAX_LEN; i++){
                pNewNode->pnext[i] = NULL;
            }
            (pCurrent->pnext)[index] = pNewNode;
        }

        pCurrent = (pCurrent->pnext)[index];
    }
#endif
    if(root != pCurrent)
    {
        pCurrent->val = 1;
    }

    return;
}

//如果该单词不是由前面的单词逐一添加一个字母构成, 返回0
int trieSearch(trienode *root, char *word, int wordlen){
    trienode *pCurrent = NULL;
    int loop;
    int sum = 0;
#if 1
    pCurrent = root;
    for(loop = 0; loop < wordlen; loop++){
        sum += pCurrent->val;
        pCurrent = (pCurrent->pnext)[word[loop]-'a'];
    }

    sum += pCurrent->val;

    if(wordlen == sum){
        return sum;
    }
#endif
    return 0;
}


char * longestWord(char ** words, int wordsSize){
    trienode *root = NULL;
    char *longestWord = NULL;
    int maxlen     = 0;
    int len;
    int loop;

    root = malloc(sizeof(trienode));
    if(!root){
        return NULL;
    }
    root->val = 0;
    for(loop = 0; loop < TRIE_MAX_LEN; loop++){
        root->pnext[loop] = NULL;
    }

    //create trie
    for(loop = 0; loop < wordsSize; loop++){
        trieInsert(root, words[loop], strlen(words[loop]));
    }

    //retrieval
    for(loop = 0; loop < wordsSize; loop++){
        len = trieSearch(root, words[loop], strlen(words[loop]));
        if(len > maxlen){
            maxlen      = len;
            longestWord = words[loop];
        }
        else if(len == maxlen && 0 != len){
            if(strcmp(longestWord, words[loop]) > 0){
                longestWord = words[loop];
            }
        }
    }

    if(0 == maxlen){
        return NULL;
    }

    return longestWord;
}