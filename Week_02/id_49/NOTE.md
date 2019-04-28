# 学习笔记
之前对于二叉树的前中后遍历，一直停留在学生时代，给定一个二叉树，能够从ABCD中选出正确答案，但是要写出递归代码，总是把自己给递进去归不来，那种深深的挫败感一直停留在对算法的黑洞里。第二周的作业，在求解LeetCode671. Second Minimum Node In a Binary Tree时，忽然想到了王争老师第三章的课件中对于二叉树遍历的讲解，四五行代码，那种感觉，简单优雅，豁然开朗。于我个人而言，这是我这周最大的收获！

二叉树的中遍历

    void inOrder(TreeNode root){
        if(null == root){
             return;
        }
        //先-左节点
        inOrder(root.left);
        //然后-根节点，得到当前节点的val，进行相关的逻辑处理
        root.val;
        //最后-右节点
        inOrder(root.right);
    }

二叉树的前序遍历

    void preOrder(TreeNode root){
        if(null == root){
             return;
        }
        //先-根节点，得到当前节点的val，进行相关的逻辑处理
        root.val;
        //然后-左节点
        inOrder(root.left);
        //最后-右节点
        inOrder(root.right);
    }

二叉树的后序遍历

    void lastOrder(TreeNode root){
        if(null == root){
             return;
        }
        //先-左节点
        inOrder(root.left);
        //然后-右节点
        inOrder(root.right);
        //最后-根节点，得到当前节点的val，进行相关的逻辑处理
        root.val;
    }

二叉树的前中后序遍历可以把二叉树表示为数组，那如果知道某个二叉树的前序数组和中序数据，如何还原二叉树?
