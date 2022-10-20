import java.util.*;
public class qubicsort {
public static void sortArr(int arr[], int n)
{
    Integer[] array = new Integer[n];
    for (int i = 0; i < n; i++)
        array[i] = arr[i];

    Arrays.sort(array, new Comparator<Integer>()
    {
        public int compare(Integer a, Integer b)
        {
            int x = (int)Math.pow(a, 3);
            int y = (int)Math.pow(b, 3);
            return (x < y) ? -1 : 1;
        }
    });
    for (int i = 0; i < n; i++)
    {
        System.out.print(array[i] + " ");
    }
}
public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int arr[]=new int[n];
    for(int i=0;i<arr.length;i++){
       arr[i]=sc.nextInt();
    }
    sortArr(arr, n);
}
}
 
    

