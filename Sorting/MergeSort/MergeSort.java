import java.util.Scanner;

public class mergeSort {

    static void merge(int[] arr, int si, int mid, int ei){
        int merged[] = new int[ei-si+1];

        int idx1=si, idx2=mid+1,index=0;

        while(idx1<=mid && idx2<=ei){
            if(arr[idx1]<=arr[idx2])
                merged[index++]=arr[idx1++];
            else
                merged[index++]=arr[idx2++];
        }

        while (idx1<=mid){
            merged[index++]=arr[idx1++];
        }

        while (idx2<=ei){
            merged[index++]=arr[idx2++];
        }

        for(int i=0, j=si;i<merged.length; i++,j++){
            arr[j]= merged[i];
        }
    }

    static void divide(int[] arr, int si, int ei){
        if(si>=ei)
            return;
        int mid = si+(ei-si)/2; //(si+ei)/2
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }

    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        divide(arr,0,n-1);
        printArray(arr);
    }
}
