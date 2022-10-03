#include<bits/stdc++.h>
using namespace std;
vector<vector<string>> v;
    bool isSafe(vector<string> ans,int r,int c,int n){
        for(int i=0;i<r;i++){
            if(ans[i][c]=='Q') return false;
        }
        
        int row = r;
        int col = c;
        while(row>=0 && col>=0){
            if(ans[row][col]=='Q') return false;
            row--;
            col--;
        }
        
        row = r;
        col = c;
        while(row>=0 && col<n){
            if(ans[row][col]=='Q') return false;
            row--;
            col++;
        }
        return true;
    }
    
    bool nQueen(vector<string>  &ans,int n,int r){
        if(r>=n){
           v.push_back(ans);
        }
        for(int i=0;i<n;i++){
            if(isSafe(ans,r,i,n)){
                ans[r][i] = 'Q';
                if(nQueen(ans,n,r+1)){
                    return true;
                }
                ans[r][i] = '.';
            }
        }
        return false;
    }
    
    vector<vector<string>> solveNQueens(int n) {
        vector<string> ans;
        string s = "";
        for(int i=0;i<n;i++){
            s += ".";
        }
        for(int i=0;i<n;i++){
            ans.push_back(s);
        }
        nQueen(ans,n,0);
        return v;
    }

int main(){
int n;
  cin>>n;
  vector<vector<string>> ans = solveNQueens(int n);
  for(auto i:ans){
  for(auto j:i){
  cout<<j;
  }
    cout<<"\n";
  }
return 0;
}
