package Sorting;

public class radix_sort {
 
    static void countingSort(int a[], int n, int div) {
    
        int count[] = new int[10];

        for (int i = 0; i < 10; i++)
            count[i] = 0;

        for (int i = 0; i < n; i++)
            count[(a[i] / div) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        int temp[] = new int[n];

        for (int i = n - 1; i > -1; i--) {
            temp[count[(a[i] / div) % 10] - 1] = a[i];
            count[(a[i] / div) % 10]--;
        }

        for (int i = 0; i < n; i++)
            a[i] = temp[i];
    }

    static void radixSort(int a[], int n) {
        int max = 0;
        for (int i = 0; i < n; i++)
            if (a[i] > max)
                max = a[i];

        for (int div = 1; max / div > 0; div *= 10) {
            countingSort(a, n, div);
        }
    }
    public static void main(String args[]) {
        int a[] = { 4, 2, 12, 6, 1, 9, 21 };
        radixSort(a, a.length);

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}
