#include<bits/stdc++.h>
using namespace std;
int main()
{  
    int t;cin>>t; while(t--)
    {
        long long n;cin>>n;long long a[n];for(int i=0;i<n;i++)cin>>a[i];
        long long m;cin>>m;long long b[m];for(int i=0;i<m;i++)cin>>b[i];
        vector<int>c;

        for(int i=0;i<n;i++)
        c.push_back(a[i]);
        for(int i=0;i<m;i++)
        { 
          if(b[i]>0)
          c.push_back(b[i]);
          else 
          continue;
        }
        long long max1=0,cursum=0;
        for(int i=0;i<c.size();i++)
          {
            cursum+=c[i];        
            if(cursum>max1)                 
            max1=cursum;              
            if(cursum<0)  
            cursum=0;
          }
          c.clear();

        
        for(int i=0;i<m;i++)
        { 
          if(b[i]>0)
          c.push_back(b[i]);
          else 
          continue;
        }
        for(int i=0;i<n;i++)
        c.push_back(a[i]);
        long long max2=0;
        cursum=0;
        for(int i=0;i<c.size();i++)
          {
            cursum+=c[i];        
            if(cursum>max2)                 
            max2=cursum;              
            if(cursum<0)  
            cursum=0;
          }
          cout<<max(max1,max2)<<endl;
    }
    
}   
