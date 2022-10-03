#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n=nums.size();;
        int p=nums[0];
        int c=1;
        for(int t=1;t<n;t++)
        {    
            if(nums[t]==p)
                c++;
            else
            {
                c--;
                if(c==0)
                {
                    c=1;
                    p=nums[t];
                }
            }
        }
        return p;
    }
};

int main()
{
    Solution s=Solution();
    vector<int> v={2,2,1,1,1,2,2};
    cout<<"Majority Element of the given vector is "<<s.majorityElement(v);
    return 0;
} 