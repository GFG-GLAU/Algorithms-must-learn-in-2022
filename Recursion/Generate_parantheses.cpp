#include<bits/stdc++.h>
using namespace std;

vector<string> v;
    void reuse(int i,int l,int r, string s,int n){
        if(i==2*n){
            v.push_back(s);
            
        }
        if(l<n){
            reuse(i+1,l+1,r,s+"(",n);
        }
        if(r<l && r<n){
            reuse(i+1,l,r+1,s+")",n);
        }
    }
int main(){
int n;
  cin>>n;
  reuse(0,0,0,"",n);
  for(auto i:v) cout<<i;
return 0;
}
