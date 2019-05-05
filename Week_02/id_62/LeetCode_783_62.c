void sort(int *a, int left, int right)
{
    if(left >= right)
    {
        return ;
    }
    int i = left;
    int j = right;
    int key = a[i]; 
    while(i < j)                            
    {
        while(i < j && key <= a[j])
        {
            j--;
        }       
        a[i] = a[j];
        while(i < j && key >= a[i])
        {
            i++;
        }         
        a[j] = a[i];
    }    
    a[i] = key;
    sort(a, left, i - 1);
    sort(a, i + 1, right);
}
 
 
int* func(struct TreeNode* root, int* tmp, int* k)
{
    if(root)
    {
        tmp[*k]=root->val;
        (*k)++;
        tmp=func(root->left,tmp,k);
        tmp=func(root->right,tmp,k);              
    }
    return tmp;
}
 
int minDiffInBST(struct TreeNode* root) 
{
    int res=INT_MAX;
    int* tmp=(int*)malloc(sizeof(int)*10000);
    int s=0;
    int* k=&s;
    tmp=func(root,tmp,k);
    sort(tmp,0,s-1);
    for(int i=1;i<s;i++)
    {
        int val=tmp[i]-tmp[i-1];
        res=res<val?res:val;
    }
    return res;
}

//4MS