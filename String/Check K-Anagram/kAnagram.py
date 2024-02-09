MAX_CHAR = 26
 
# Function to check that is
# k-anagram or not
def arekAnagrams(str1, str2, k) :
 
    # If both strings are not of equal
    # length then return false
    n = len(str1)
    if (len(str2)!= n) :
        return False
 
    count1 = [0] * MAX_CHAR
    count2 = [0] * MAX_CHAR
 
    # Store the occurrence of all
    # characters in a hash_array
    for i in range(n):
        count1[ord(str1[i]) -
               ord('a')] += 1
    for i in range(n):
        count2[ord(str2[i]) -
               ord('a')] += 1
         
    count = 0
 
    # Count number of characters that
    # are different in both strings
    for i in range(MAX_CHAR):
        if (count1[i] > count2[i]) :
            count = count + abs(count1[i] -
                                count2[i])
 
    # Return true if count is less
    # than or equal to k
    return (count <= k)
 
# Driver Code
if __name__ == '__main__':
    str1 = "anagram"
    str2 = "grammar"
    k = 2
    if (arekAnagrams(str1, str2, k)):
        print("Yes")
    else:
        print("No")
