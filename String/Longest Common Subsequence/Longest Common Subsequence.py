"""
LCS Problem Statement: Given two sequences, find the length of longest subsequence
present in both of them.  A subsequence is a sequence that appears in the same relative
order, but not necessarily continuous.
Example:"abc", "abg" are subsequences of "abcdefgh".
"""


def longest_common_subsequence(x: str, y: str):

    assert x is not None
    assert y is not None

    m = len(x)
    n = len(y)

    L = [[0] * (n + 1) for _ in range(m + 1)]

    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if x[i - 1] == y[j - 1]:
                match = 1
            else:
                match = 0

            L[i][j] = max(L[i - 1][j], L[i][j - 1], L[i - 1][j - 1] + match)

    seq = ""
    i, j = m, n
    while i > 0 and j > 0:
        if x[i - 1] == y[j - 1]:
            match = 1
        else:
            match = 0

        if L[i][j] == L[i - 1][j - 1] + match:
            if match == 1:
                seq = x[i - 1] + seq
            i -= 1
            j -= 1
        elif L[i][j] == L[i - 1][j]:
            i -= 1
        else:
            j -= 1

    return L[m][n], seq


if __name__ == "__main__":
    a = "AGGTAB"
    b = "GXTXAYB"
    expected_ln = 4
    expected_subseq = "GTAB"

    ln, subseq = longest_common_subsequence(a, b)
    print("len =", ln, ", sub-sequence =", subseq)
    import doctest

    doctest.testmod()
