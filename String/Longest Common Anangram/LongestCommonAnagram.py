# Python 3 implementation to find
# the length of the longest common
# anagram subsequence

SIZE = 26

# function to find the length of the
# longest common anagram subsequence
def longCommonAnagramSubseq(str1, str2,
								n1, n2):

	# List for storing frequencies
	# of each character
	freq1 = [0] * SIZE
	freq2 = [0] * SIZE
	
	l = 0
	
	# calculate frequency of each
	# character of 'str1[]'
	for i in range(n1):
		freq1[ord(str1[i]) -
			ord('a')] += 1
	
	# calculate frequency of each
	# character of 'str2[]'
	for i in range(n2) :
		freq2[ord(str2[i]) -
			ord('a')] += 1
	
	# for each character add its
	# minimum frequency out of
	# the two strings in 'len'
	for i in range(SIZE):
		l += min(freq1[i], freq2[i])
	
	# required length
	return l							

# Driver Code
if __name__ == "__main__":
	
	str1 = "abdacp"
	str2 = "ckamb"
	n1 = len(str1)
	n2 = len(str2)
	print("Length = ",
		longCommonAnagramSubseq(str1, str2,
									n1, n2))
 
