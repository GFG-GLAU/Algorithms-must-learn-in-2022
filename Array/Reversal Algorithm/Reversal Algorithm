/*
    In this Ninja Technique we reverse the the elements in the Array.
    Time Complexity of this --> O(N/2)
    Space Complexity of this --> O(1)

*/


public class Reversal_Algorithm {

    public static void main(String[] args) {
        int[] arr = {1,2 ,3 ,4,5 ,6 ,7};
        System.out.println(Arrays.toString(arr));
        reverse_array(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse_array(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {

            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;

            s++;
            e--;
        }
    }
}
