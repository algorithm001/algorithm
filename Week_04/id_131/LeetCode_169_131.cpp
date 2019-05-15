/*
  997.�ʵ�����ĵ���
  ����һ���ַ�������words��ɵ�һ��Ӣ��ʵ䡣�����ҳ����һ�����ʣ�
  �õ�������words�ʵ����������������һ����ĸ��ɡ��������ж�����еĴ𰸣�
  �򷵻ش����ֵ�����С�ĵ��ʡ�
  
  ���޴𰸣��򷵻ؿ��ַ�����

ʾ�� 1:
����: 
words = ["w","wo","wor","worl", "world"]
���: "world"
����: 
����"world"����"w", "wo", "wor", �� "worl"���һ����ĸ��ɡ�

ʾ�� 2:
����: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
���: "apple"
����: 
"apply"��"apple"�����ɴʵ��еĵ�����ɡ�����"apple"���ֵ���С��"apply"��

*/

/*
  ˼· 1 ��
  1�����ù�ϣ����
*/
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        //������ϣ���������г��ִ�������n/2����
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
  ˼· 2��Ħ��ͶƱ��
  
  �ȼ����һ��������������cnt=1������������������ͬ��cnt+1����ͬ���һ��
  ��cntΪ0ʱ������µ�����Ϊ��ѡ��������ǰ�᣺�г��ִ�������n/2�������ڣ�
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
  ˼· 3��λ���㷨
  
  ͳ��ÿ������ÿһλ0��1���ֵĴ��������ĳһλ1���ֵĴ��������λΪ1��0ͬ��
  ���Ϊͳ�Ƴ���������������
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