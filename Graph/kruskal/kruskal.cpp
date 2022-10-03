// BY DSU
#include<bits/stdc++.h>
using namespace std;
int par(vector<int>&v,int i)
{
    if(v[i]==i)
        return i;
    return v[i]=par(v,v[i];
}
void make(int a,int b,vector<int>&g,vector<int>&size)
{
    int u =par(g,a);
    int v =par(g,b);
    
    if(size(v)>size(u))
    swap(u,v);
    
    g[v]=u;
    size[u]+=size[v];
    
}
int main()
{
    int nodes,edge;cin>>node>>edge;
    vector<vector<int>>v;
    vector<int>size;
    vector<int>g;
    for(int i = 0;i<nodes;++i)
    {
        g.push_back(i);
        size.push_back(1);
    }
    while(edge--)
    {
        int src,to,dis;cin>>src>>to>>dis;
        v.push_back({dis,src,to});
    }
    sort(v.begin(),v.end());
    int sum = 0;
    for(auto c:v)
    {
    int u =par(a,c[1]);
    int v = par(b,c[2]);
        if(u==v)
            continue;
        make(u,v);
        sum+=c[0];
    
    }
    cout<<sum<<"\n";
    return  0;
}
