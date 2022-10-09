class Solution {
public:
    int dp[25][35];
    bool solve(string s, string p, int i, int j, int m, int n) {
        if(i == m && j == n) return true;
        if(j == n) return false;
        if(dp[i][j] != -1) return dp[i][j];
        if(j+1 < n && p[j+1] == '*') {
            return dp[i][j] = solve(s, p, i, j+2, m, n) || ((i < m && (s[i] == p[j] || p[j] == '.')) ? solve(s, p, i+1, j, m, n) : false);
        }
        if(i < m && s[i] == p[j] || p[j] == '.') {
            return dp[i][j] = solve(s, p, i+1, j+1, m, n);
        }
        return dp[i][j] = false;
    }
    bool isMatch(string s, string p) {
        int m = s.length();
        int n = p.length();
        memset(dp, -1, sizeof(dp));
        return solve(s, p, 0, 0, m, n);
    }
};