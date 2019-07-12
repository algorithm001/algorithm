#ifndef SOLUTION_H
#define SOLUTION_H

#include <vector>
#include <string>

#include <hash_map>
#include <stack>

#include <sstream>
using namespace  __gnu_cxx;
using namespace std;

class Solution
{
public:
    Solution();

    static vector<int> twoSum(int a[], int len, int target);
    static vector<int> twoSum2(int a[], int len, int target);
    static vector<int> twoSum3(int a[], int len, int target);




};

vector<int> Solution::twoSum(int a[], int len,int target)
{
    //1 traverse the array
    vector<int> res;
    res.clear();
    for(int i = 0; i < len; ++i)
    {
        for(int j = i+1; j < len; ++j)
        {
            if(a[i] + a[j] == target)
            {
                res.push_back(i);
                res.push_back(j);

                return res;

            }
        }
    }
    //
    return res;
}

vector<int> Solution::twoSum2(int a[], int len, int target)
{
    //1 traverse the array
    vector<int> res;
    res.clear();
    hash_map<int,int> val2Mark;

    for(int i = 0; i < len; ++i)
    {
        val2Mark[a[i]] = i;
    }

    for(int i = 0; i < len; ++i)
    {
        auto it = val2Mark.find(target - a[i]);
        if(it != val2Mark.end())
        {
            res.push_back(i);
            res.push_back(it->second);

            return res;

        }
    }

    //
    return res;
}

vector<int> Solution::twoSum3(int a[], int len, int target)
{
    //1 traverse the array
    vector<int> res;
    res.clear();


    hash_map<int,int> val2Mark;
    for(int i = 0; i < len; ++i)
    {
        val2Mark[a[i]] = i;
        auto it = val2Mark.find(target - a[i]);
        if(it != val2Mark.end())
        {
            res.push_back(i);
            res.push_back(it->second);

            return res;

        }
    }

    //
    return res;
}

#endif // SOLUTION_H
