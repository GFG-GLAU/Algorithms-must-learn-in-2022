#include<bits/stdc++.h>
#define NODE 5
using namespace std;
                               
int graph[NODE][NODE] = {
   {0, 0, 1, 1, 0},
   {1, 0, 0, 0, 0},
   {0, 1, 0, 0, 0},
   {0, 0, 1, 0, 1},
   {1, 0, 0, 0, 1}
};               
int min(int a, int b) {
   return (a<b)?a:b;
}              
void findComponent(int u, int disc[], int low[], stack<int>&stk, bool stkItem[]){
   static int time = 0;
   disc[u] = low[u] = ++time;  
   stk.push(u);
   stkItem[u] = true;
   for(int v = 0; v<NODE; v++){
      if(graph[u][v]) {
         if(disc[v] == -1) {
            findComponent(v, disc, low, stk, stkItem);
            low[u] = min(low[u], low[v]);
         } else if(stkItem[v])
            low[u] = min(low[u], disc[v]);
      }
   }
   int poppedItem = 0;
   if(low[u] == disc[u]) {
      while(stk.top() != u) {
         poppedItem = stk.top();
         cout << poppedItem << " ";
         stkItem[poppedItem] = false;
         stk.pop();
      }
      poppedItem = stk.top();
      cout << poppedItem <<endl;
      stkItem[poppedItem] = false;
      stk.pop();
   }
}               
void strongConComponent(){
   int disc[NODE], low[NODE];
   bool stkItem[NODE];
   stack<int> stk;
   for(int i = 0; i<NODE; i++){
      disc[i] = low[i] = -1;
      stkItem[i] = false;
   }
   for(int i = 0; i<NODE; i++)
      if(disc[i] == -1)
         findComponent(i, disc, low, stk, stkItem);
}

int main(){
   strongConComponent();
}
