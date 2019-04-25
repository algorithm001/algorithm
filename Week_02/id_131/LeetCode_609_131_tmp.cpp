/* 题目描述 :
 * 在系统中查找重复文件
 * 给定一个目录信息列表，包括目录路径，以及该目录中的所有包含内容的文件，
 * 您需要找到文件系统中的所有重复文件组的路径。一组重复的文件至少包括二个具有完全相同内容的文件
 
 * 示例 1：
 * 输入：
 * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 * 输出：
 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
*/
class Solution {
public:
    vector<vector<string>> findDuplicate(vector<string>& paths) 
    {
        vector<vector<string>> resultVec;
        // key:文件内容  value:文件目录列表
        unordered_map<string, vector<string>> hashMap;
        for(auto& path : paths)
        {
            
        }
        
        
        return resultVec;
    }
};