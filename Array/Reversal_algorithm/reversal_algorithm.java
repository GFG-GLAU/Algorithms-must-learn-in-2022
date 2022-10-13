import java.io.*;
 
class GFG
{
    static void reverseArray(int arr[], int start,
                             int end)
    {
        while (start < end)
        {
           int temp = arr[start];
           arr[start] = arr[end];
           arr[end] = temp;
           start++;
           end--;
         }
    }
 
   
    static void rightRotate(int arr[], int d, int n)
    {
       reverseArray(arr, 0, n - 1);
       reverseArray(arr, 0, d - 1);
       reverseArray(arr, d, n - 1);
    }
 
   
    static void printArray(int arr[], int size)
    {
       for (int i = 0; i < size; i++)
          System.out.print(arr[i] + " ");
    }
 
    public static void main (String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5,
                     6, 7, 8, 9, 10};
     
    int n = arr.length;
    int k = 3;
     
    rightRotate(arr, k, n);
    printArray(arr, n);
         
    }
}
