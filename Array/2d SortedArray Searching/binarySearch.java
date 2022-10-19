static int search(int[][] mat, int n, int x)
    {
        if (n == 0)
            return -1;
 
        // traverse through the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                // if the element is found
                if (mat[i][j] == x) {
                    System.out.print("Element found at ("
                                     + i + ", " + j
                                     + ")\n");
                    return 1;
                }
        }
 
        System.out.print(" Element not found");
        return 0;
    }
