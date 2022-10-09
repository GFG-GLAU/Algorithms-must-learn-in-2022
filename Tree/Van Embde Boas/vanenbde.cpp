#include <bits/stdc++.h>
using namespace std;

class Van_Emde_Boas {

public:
	int universe_size;
	int minimum;
	int maximum;
	Van_Emde_Boas* summary;
	vector<Van_Emde_Boas*> clusters;

	int high(int x)
	{
		int div = ceil(sqrt(universe_size));
		return x / div;
	}

	int low(int x)
	{
		int mod = ceil(sqrt(universe_size));
		return x % mod;
	}

	int generate_index(int x, int y)
	{
		int ru = ceil(sqrt(universe_size));
		return x * ru + y;
	}

	Van_Emde_Boas(int size)
	{
		universe_size = size;
		minimum = -1;
		maximum = -1;

		if (size <= 2) {
			summary = nullptr;
			clusters = vector<Van_Emde_Boas*>(0, nullptr);
		}
		else {
			int no_clusters = ceil(sqrt(size));

			summary = new Van_Emde_Boas(no_clusters);

			clusters = vector<Van_Emde_Boas*>(no_clusters, nullptr);

			for (int i = 0; i < no_clusters; i++) {
				clusters[i] = new Van_Emde_Boas(ceil(sqrt(size)));
			}
		}
	}
};

int main()
{
	Van_Emde_Boas* akp = new Van_Emde_Boas(4);
}
