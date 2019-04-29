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
            int pathSize = path.size(), index = 0;
			string filePath = "", fileName = "", fileContent = "";
			
			// 读取当前 path 的路径
			while (index < pathSize && path[index] != ' ')
			{
				filePath += path[index++];
			}
			
			filePath += '/'; // path 最后需添加斜杠
			index += 1; // 跳过空格
			
			// 读取文件名 与 文件内容
			while(index < pathSize)
			{
				fileName = "";
				fileContent = "";
				
				// 读取文件名
				while(index < pathSize && path[index] != '(')
				{
					fileName += path[index++];
				}
				index += 1; // 跳过右括号
				
				// 读取文件内容
				while(index < pathSize && path[index] != ')')
				{
					fileContent += path[index++];
				}
				index += 2; // 跳过右括号 和 空格
				
				// 将文件内容 与文件目录类表放入 map 中
				hashMap[fileContent].push_back(filePath + fileName);
			}
        }
        
		// 查找重复的文件至少包括二个具有完全相同内容的文件
		for(auto &item : hashMap)
		{
			if(item.second.size() > 1)
			{
				resultVec.push_back(item.second);
			}
		}
        
        return resultVec;
    }
};