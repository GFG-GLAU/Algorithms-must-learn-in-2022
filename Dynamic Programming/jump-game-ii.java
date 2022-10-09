/*
Problem Link - https://leetcode.com/problems/jump-game-ii/
Explanation - In this solution i have used memoization and trie all the possible ways in whoch we can jump and considered the minimum.
 */





  class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return traverse(0,nums,dp);
    }

    private int traverse(int idx, int[] nums, int[] dp){
        if(idx >= nums.length-1) return 0;
        if(dp[idx] != -1) return dp[idx];
        int min = 100000;
        for (int i = idx+1; i <= nums[idx]+idx; i++){
            min = Math.min(min,1+traverse(i,nums,dp));
        }
        dp[idx] = min;
        return min;
    }
}
