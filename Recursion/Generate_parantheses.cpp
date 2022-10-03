  vector<string> parantheses;
    void Generate_Parenthesis(int i,int left,int right, string s,int n){
        if(i==2*n){
            parantheses.push_back(s);
        }
        if(left<n){
            Generate_Parenthesis(i+1,left+1,right,s+"(",n);
        }
        if(right<left && right<n){
            Generate_Parenthesis(i+1,left,right+1,s+")",n);
        }
    }
    int main(){
    int n;
      cin>>n;
      Generate_Parenthesis(0,0,0,"",n);
      for(auto i:parantheses) cout<<i<<"\n";
    return 0;
    }
