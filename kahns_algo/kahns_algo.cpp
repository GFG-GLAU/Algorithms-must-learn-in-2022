#include<bits/stdc++.h>
using namespace std;
 
int main()
{
   int x, y, e,v;
   cin >> v >> e; // Number of vertices and edges
   vector <int> AdjList[v]; // Step 1: Initializing AdjList
   vector<int> indegree(v, 0); // Step 1: Initializing indegrees to 0
   queue <int> q;
 
   int visited_nodes = 0; // Step 1: Visited nodes initialized to 0
 
   for(int i=0; i < e; i++)
   {
       cin >> x >> y;
       indegree[y]++; // Incrementing indegree
       AdjList[x].push_back(y); // Add the edge x -> y to adjacency list
   }
 
   for(int i = 0; i < v; i++)
       if(indegree[i]==0) q.push(i); // Step 2: Add all indegree 0 nodes to queue
 
   while(!q.empty()) // Step 3: Remove vertex from queue
   {
       visited_nodes++; // Step 3.1 Incrementing count of visited nodes
       for(auto x: AdjList[q.front()])
       {
           indegree[x]--; // Step 3.2 Reduce indegree of adjacent node
           if(indegree[x]==0) q.push(x); // Step 3.3 Push adjacent node with indegree 0
       }
 
       cout << q.front()<<" ";
       q.pop();
      
   } // Step 4: Repeat until queue is empty
 
   if(visited_nodes != v) // Step 5: if visited nodes are not equal to number of vertices, cycle exists
       cout<<"\nCycle exists, cannot do further topological sort"; 
}
