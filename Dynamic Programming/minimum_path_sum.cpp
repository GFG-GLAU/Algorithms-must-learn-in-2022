class Solution {
public:
    /*
    int f(int row,int col, vector<vector<int>>& dp,vector<vector<int>> grid){
        if(row==0 && col==0)
            return dp[row][col]=grid[0][0];
        if(row<0 || col<0)
            return 10e5;
        if(dp[row][col]!=-1)
            return dp[row][col];
        long int up=grid[row][col]+f(row-1,col,dp,grid);
        long int left=grid[row][col]+f(row,col-1,dp,grid);
        return dp[row][col]=min(up,left);
    }
    */
    int minPathSum(vector<vector<int>>& grid) {
        int r=grid.size();
        int c=grid[0].size();
        vector<vector<int>> dp(r,vector<int>(c,0));
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 && j==0)
                    dp[i][j]=grid[i][j];
                else{
                    int up=grid[i][j];
                    if(i>0) 
                        up+=dp[i-1][j];
                    else
                        up+=10e7;
                    int left=grid[i][j];
                    if(j>0)
                        left+=dp[i][j-1];
                    else
                        left+=10e7;
                    dp[i][j]=min(left,up);
                }
            }
        }
        return dp[r-1][c-1];
    }
};