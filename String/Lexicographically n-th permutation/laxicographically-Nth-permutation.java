import java.util.*;
 
class GFG
{
 
// Function to print nth permutation
// using next_permute()
static void nPermute(char[] str, int n)
{
    // Sort the string in lexicographically
    // ascending order
    Arrays.sort(str);
 
    // Keep iterating until
    // we reach nth position
    int i = 1;
    do {
        // check for nth iteration
        if (i == n)
            break;
 
        i++;
    } while (next_permutation(str));
 
    // print string after nth iteration
    System.out.println(String.valueOf(str));
}
 
static boolean next_permutation(char[] p)
{
    for (int a = p.length - 2; a >= 0; --a)
        if (p[a] < p[a + 1])
        for (int b = p.length - 1;; --b)
            if (p[b] > p[a])
            {
                char t = p[a];
                p[a] = p[b];
                p[b] = t;
                for (++a, b = p.length - 1; a < b; ++a, --b)
                {
                    t = p[a];
                    p[a] = p[b];
                    p[b] = t;
                }
                return true;
            }
    return false;
}
 
// Driver code
public static void main(String[] args)
{
    String str = "GEEKSFORGEEKS";
    int n = 100;
    nPermute(str.toCharArray(), n);
}
}
