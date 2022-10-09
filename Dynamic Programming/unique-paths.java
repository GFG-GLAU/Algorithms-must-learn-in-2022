/*

Problem Link -  https://leetcode.com/problems/unique-paths/
  Explanation - In the problem I am trying to go from bottom to top for that I am starting from the bottom right corner and going to the origin i.e, 0,0 and at each step 
  I am taking the two case going to left and top.
  After that summing up the total number of outcomes 
  
  */


class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return calculate(m-1,n-1,dp);
        
    }
    
    private int calculate(int i, int j, int[][] dp){
        if (i == 0 &&  j == 0){
            return 1;
        }
        if (i < 0 || j < 0){
            return 0;
        }
        if (dp[i][j] != 0){
            return dp[i][j];
        }
        int right = calculate(i-1,j,dp);
        int up = calculate(i,j-1,dp);
        return dp[i][j] = up+right;
    }
}
