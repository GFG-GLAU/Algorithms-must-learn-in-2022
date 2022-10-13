class Hash {
    final int p = 31, m = 1000000007;
    int hash_value;
    Hash(String S) {
        int hash_so_far = 0;
        final char[] s = S.toCharArray();
        long p_pow = 1;
        final int n = s.length;
        for (int i = 0; i < n; i++) {
            hash_so_far = (int)((hash_so_far + (s[i] - 'a' + 1) * p_pow) % m);
            p_pow = (p_pow * p) % m;
        }
        hash_value = hash_so_far;
    }
}
 
class Main {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        Hash h = new Hash(s);
        System.out.println("Hash of " + s + " is " + h.hash_value);
    }
}
