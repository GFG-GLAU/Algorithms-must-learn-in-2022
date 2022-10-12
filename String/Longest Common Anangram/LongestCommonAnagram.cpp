// C++ implementation to find the length of the
// longest common anagram subsequence
#include <bits/stdc++.h>

using namespace std;

#define SIZE 26

// function to find the length of the
// longest common anagram subsequence
int longCommonAnagramSubseq(char str1[], char str2[],
								int n1, int n2)
{
	// hash tables for storing frequencies of
	// each character
	int freq1[SIZE], freq2[SIZE];
	memset(freq1, 0, sizeof(freq1));
	memset(freq2, 0, sizeof(freq2));
	
	int len = 0;
	
	// calculate frequency of each character
	// of 'str1[]'
	for (int i = 0; i < n1; i++)
		freq1[str1[i] - 'a']++;
	
	// calculate frequency of each character
	// of 'str2[]'
	for (int i = 0; i < n2; i++)
		freq2[str2[i] - 'a']++;
	
	// for each character add its minimum frequency
	// out of the two strings in 'len'
	for (int i = 0; i < SIZE; i++)
		len += min(freq1[i], freq2[i]);
	
	// required length
	return len;
}							

// Driver program to test above
int main()
{
	char str1[] = "abdacp";
	char str2[] = "ckamb";
	int n1 = strlen(str1);
	int n2 = strlen(str2);
	cout << "Length = "
		<< longCommonAnagramSubseq(str1, str2, n1, n2);
	return 0;	
}
