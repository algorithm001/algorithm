struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};


int findSecondMinimumValue(struct TreeNode* root) {
    struct TreeNode* left = root->left;
    struct TreeNode* right = root->right;

    int ret;
    int ret1;

    if(NULL != left && NULL == right)
    {
        if(root->val != left->val)
        {
            return left->val;
        }

        return findSecondMinimumValue(left);
    }
    else if(NULL == left && NULL != right)
    {
        if(root->val != right->val)
        {
            return right->val;
        }

        return findSecondMinimumValue(right);
    }
    else if(NULL == left && NULL == right)
    {
        return -1;
    }

    if(left->val == right->val)
    {
        ret = findSecondMinimumValue(left);
        ret1 = findSecondMinimumValue(right);

        if(-1 != ret && -1 != ret1)
        {
            return ret > ret1 ? ret1: ret;
        }

        return ret == -1 ? ret1 : ret;
    }
    else
    {
        if(root->val == left->val)
        {
            ret = findSecondMinimumValue(left);

            if(-1 == ret)
            {
                return right->val;
            }

            return ret > right->val ? right->val : ret;
        }
        else if(root->val == right->val)
        {
            ret = findSecondMinimumValue(right);

            if(-1 == ret)
            {
                return left->val;
            }

            return ret > left->val ? left->val : ret;
        }

        return left->val > right->val ? right->val : left->val;
    }
}