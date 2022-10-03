//to do the vertical order traversal of a binary tree.
// coordinate system concept is used.
#include<bits/stdc++.h>
using namespace std;
struct node
{  int data;
   node *left,*right;
};
struct node* newnode(int val)
{  struct node *temp=new node;
   temp->data=val;
   temp->left=NULL;
   temp->right=NULL;
   return temp;
}
vector<vector<int>> verticaltraveral(node* root){
    map<int,map<int,multiset<int>>> nodes;
    queue<pair<node*,pair<int,int>>> todo;
    todo.push({root,{0,0}});
    while(!todo.empty()){
        auto p=todo.front();
        todo.pop();
        node* temp=p.first;
        int x=p.second.first,y=p.second.second;
        nodes[x][y].insert(temp->data);
        if(temp->left)  todo.push({temp->left,{x-1,y+1}});
        if(temp->right)  todo.push({temp->right,{x+1,y+1}});
    }
    vector<vector<int>> ans;
    for(auto it:nodes){
        vector<int> col;
        for(auto it1:it.second){
            col.insert(col.end(),it1.second.begin(),it1.second.end());
        }
        ans.push_back(col);
    }
    return ans;
}
int main()
{ vector<vector<int>> ans;
  struct node* root=newnode(10);
  root->left=newnode(20);
  root->right=newnode(30);
  root->left->left=newnode(40);
  root->left->right=newnode(50);
  root->right->left=newnode(60);
  root->right->right=newnode(70);
  ans=verticaltraveral(root);
  for(auto it:ans)
  {  for(auto it1:it)
       cout<<it1<<" ";
     cout<<endl;
  }
  return 0;
}
