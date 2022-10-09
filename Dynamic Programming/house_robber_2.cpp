/* Problem Statement ->
213. House Robber II
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:
Input: nums = [1,2,3]
Output: 3

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000
*/

/* Solution -> */

class Solution {
public:
    int rob(vector<int>& nums) {
       int n = nums.size();
        if(n==0)
            return 0;
        if(n==1)
            return nums[0];
        if(n==2)
            return max(nums[0], nums[1]);
        int t1[n-1], t2[n];
        t1[0] = t1[1] = nums[0];
        t2[1] = nums[1];
        t2[2] = max(nums[1],nums[2]);


        for(int i=2; i<n-1; i++){
            t1[i] = max(t1[i-1], nums[i] + t1[i-2]);
        }

        for(int i=3; i<n; i++){
            t2[i] = max(t2[i-1], nums[i] + t2[i-2]);
        }

        return max(t1[n-2], t2[n-1]);
    }
};


/* Output ->
Your input - [2,3,2]
Output - 3
Expected - 3
*/