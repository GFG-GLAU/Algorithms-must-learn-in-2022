public class Solution{
    static int missingNumber1(int[] arr,int size){
        for(int i=0;i<size;i++){
            int n = (int)Math.abs(arr[i]);
            if(arr[i]>0 && arr[i]<(n+1)){
                arr[arr[i]-1] = -arr[arr[i]-1];
            }
        }
        int j=0;
        for(;j<size;j++){
            if(arr[j]>0){
                return j+1;
            }
        }
        return j+1;
    }
    static int segregate(int[] arr,int size){
        int j=0;
        for(int i=0;i<size;i++){
            if(arr[i]<0 || arr[i]>size+1){
                swap(arr,j,i);
                j++;
            }
        }
        return j;
    }
    static int findMissingnumber(int[] arr,int size) {
        int segregate = segregate(arr, size);
        int narr[] = new int[segregate];
        for (int i = segregate; i < size; i++) {
            narr[i - segregate] = arr[i];
        }
        return missingNumber1(narr, segregate);
    }
    static int missingNumber(int arr[], int size)
    {
//        Approach:
//        1. Since we have to find the smallest missing +ve element and the size is n
//        2. missing number should lie in domain [1,n+1].
//        In first loop:
//        1. whenever we encounter a +ve number we check that if number is in domain [1, n].
//        2. if number is in domain, we place it at its correct position (if the current number is duplicate
//        then we don't place it and move on).
//        3. we swap the number with number at index number-1
//        At last, number n must be present at index n-1, n > 0
//        In second loop, we check if the number at index i doesn't equal to i+1, we return i+1 as it is the missing number.
//        if we don't find number in second loop then it means that all numbers in domain [1, n] are present

         for(int i=0;i<size;i++){
             if(arr[i]>0 && arr[i]<=size){
                 if(arr[i]!=arr[arr[i]-1]){
                     swap(arr,i,arr[i]-1);
                     i--;
                 }
             }
         }
         int i=0;
         for(;i<size;i++){
             if(arr[i]!=(i+1))
             break;
         }
         return i+1;

    }
    static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
