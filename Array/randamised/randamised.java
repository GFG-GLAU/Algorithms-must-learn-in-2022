
import java.io.*;
import java.util.*;
import java.math.*;
 
class Main {
    static int N = 2;

    static boolean freivald(int a[][], int b[][],
                                       int c[][])
    {
       
        int r[] = new int[N];
        for (int i = 0; i < N; i++)
        r[i] = (int)(Math.random()) % 2;
 
        int br[] = new int[N];
        Arrays.fill(br, 0);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                br[i] = br[i] + b[i][j] * r[j];
 
      
        int cr[] = new int[N];
        Arrays.fill(cr, 0);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                cr[i] = cr[i] + c[i][j] * r[j];
 
       
        int axbr[] = new int[N];
        Arrays.fill(axbr, 0);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                axbr[i] = axbr[i] + a[i][j] * br[j];
 
       
        for (int i = 0; i < N; i++)
            if (axbr[i] - cr[i] != 0)
                return false;
 
        return true;
    }

    static boolean isProduct(int a[][], int b[][],
                                 int c[][], int k)
    {
        for (int i = 0; i < k; i++)
            if (freivald(a, b, c) == false)
                return false;
        return true;
    }
 

    public static void main(String args[])
    {
        int a[][] = { { 1, 1 }, { 1, 1 } };
        int b[][] = { { 1, 1 }, { 1, 1 } };
        int c[][] = { { 2, 2 }, { 2, 2 } };
        int k = 2;
        if (isProduct(a, b, c, k))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}