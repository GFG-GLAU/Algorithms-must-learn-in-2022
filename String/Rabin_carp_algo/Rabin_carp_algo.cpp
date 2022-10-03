#include <bits/stdc++.h>
using namespace std;
vector<int> v;
void search(string pattern, string str, int q,int d){
	int M = pattern.size();
	int N = str.size();
	int i, j;
	int p = 0;
	int t = 0;
	int h = 1;
	for(i=0;i<M-1;i++)
		h = (h*d)%q;
	for(i=0;i<M;i++) {
		p = (d*p+pattern[i])%q;
		t = (d*t+str[i])%q;
	}
	for(i=0;i<=N-M;i++){
		if(p==t){
			for(j=0;j<M;j++){
				if(str[i+j]!=pattern[j]){
					break;
				}
			}
			if(j==M)
				v.push_back(i);
		}
		if(i<N-M){
			t = (d*(t-str[i]*h)+str[i+M])%q;
			if(t<0)
				t = (t+q);
		}
	}
}

int main(){
	string pattern,str;
	cin>>str;
	cin>>pattern;
	int q = INT_MAX;
	search(pattern, str, q,256);
	if(v.size()){
	    cout<<"Pattern found at :- \n";
	for(auto i:v) cout<<i<<" ";
	}
	else{
	    cout<<"No Pattern found";
	}
	return 0;
}
