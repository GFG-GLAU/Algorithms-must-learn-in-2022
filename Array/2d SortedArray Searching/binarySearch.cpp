and returns false */
int search(int mat[4][4], int n, int x)
{
    if (n == 0)
        return -1;
 
    // traverse through the matrix
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            // if the element is found
            if (mat[i][j] == x) {
                cout << "Element found at (" << i << ", "
                     << j << ")\n";
                return 1;
            }
    }
 
    cout << "n Element not found";
    return 0;
}
