// inoder preorder postorder traversal using recursion
#include<bits/stdc++.h>
using namespace std;
struct node
{  int data;
   node *right, *left;
};
struct node* newnode(int key)
{  struct node* temp= new node;
   temp->data=key;
   temp->right=temp->left=NULL;
   return temp;
}
void preorder(struct node* temp)
{  if(temp==NULL)
     return;
   cout<<temp->data<<" ";
   preorder(temp->left);
   preorder(temp->right);
}
void inorder(struct node* temp)
{  if(temp==NULL)
     return;
   inorder(temp->left);
   cout<<temp->data<<" ";
   inorder(temp->right);
}
void postorder(struct node* temp)
{  if(temp==NULL)
     return;
   postorder(temp->left);
   postorder(temp->right);
   cout<<temp->data<<" ";
}
int main()
{  struct node* root=newnode(10);
   root->left=newnode(20);
   root->right=newnode(30);
   root->left->left=newnode(40);
   root->left->right=newnode(50);
   root->right->left=newnode(60);
   root->right->right=newnode(70);
   cout<<"preorder traversal:- ";
   preorder(root);
   cout<<endl;
   cout<<"Inorder traversal:- ";
   inorder(root);
   cout<<endl;
   cout<<"postorder traversal:- ";
   postorder(root);
   return 0;
}
