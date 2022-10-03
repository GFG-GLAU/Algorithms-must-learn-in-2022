#include<bits/stdc++.h>
using namespace std;
const long long MAX_SIZE = 1000001;
vector<long long >isprime(MAX_SIZE , true);
vector<long long >prime;
vector<long long >Small_fac(MAX_SIZE);
void seive(int n){
	isprime[0] = isprime[1] = false ;
	for (long long int i=2; i<=n ; i++){
		if (isprime[i]){
			prime.push_back(i);
			Small_fac[i] = i;
		}
		for (long long int j=0;j<(int)prime.size()&&i*prime[j]<n&&prime[j]<=Small_fac[i];j++){
			isprime[i*prime[j]]=false;
			Small_fac[i*prime[j]] = prime[j] ;
		}
	}
}

int main(){
    int n;
    cin>>n;
	seive(n);
	for (int i=0;i<prime.size()&&prime[i]<=n;i++)
		cout << prime[i] << " ";
	return 0;
}
