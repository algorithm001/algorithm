/*
  997.词典中最长的单词
  给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，
  该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，
  则返回答案中字典序最小的单词。
  
  若无答案，则返回空字符串。

示例 1:
输入: 
words = ["w","wo","wor","worl", "world"]
输出: "world"
解释: 
单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。

示例 2:
输入: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出: "apple"
解释: 
"apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。

*/

/*
  思路 1 ：
  1、利用哈希数组
*/
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        //建立哈希数组找其中出现次数大于n/2的数
        unordered_map<int,int> hash;
        int res=0;
        int len=nums.size();
        for(int i=0;i<len;i++){
            hash[nums[i]]++;
            if(hash[nums[i]]>len/2)
                res=nums[i];
        }
        return res;
    }
};

/*
  思路 2：摩尔投票法
  
  先假设第一个数过半数并设cnt=1；遍历后面的数如果相同则cnt+1，不同则减一，
  当cnt为0时则更换新的数字为候选数（成立前提：有出现次数大于n/2的数存在）
*/
class Solution {
public:
    int majorityElement(vector<int>& nums) {

        int res=0,cnt=0;
        for(int i=0;i<nums.size();i++){
            if(cnt==0) {
                res=nums[i];
                cnt++;
            }
            else{
                res==nums[i]?cnt++:cnt--;
            }
        }
        return res;
    }
};

/*
  思路 3：位运算法
  
  统计每个数字每一位0，1出现的次数，如果某一位1出现的次数多则该位为1，0同理；
  最后按为统计出来的数就是众数
*/
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int res=0,len = nums.size();
        for(int i=0;i<32;i++){
            int ones=0,zero=0;
            for(int j=0;j < len; j++){
                if(ones>len/2 ||zero>len/2) break;
                if((nums[j]&(1<<i)) != 0) ones++;
                else zero++;   
            }
            if(ones > zero)
                 res = res|(1<<i);
        }
        return res;
    }
};