/*

    In this ninja technique we check the element with all the elements in the Array.
    Time Complexity of this is --> O(N)
    Space complexity of this is --> O(1)

*/



import java.util.*;
class LinearSearching{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("INPUT THE SIZE OF THE ARRAY");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("INPUT ELEMENTS IN ARRAY");
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("INPUT THE ELEMENT TO BE SEARCHED IN ARRAY");
        int target = sc.nextInt();

        if(positionOfElement(arr , target))
            System.out.println("ELEMENT IS PRESENT IN ARRAY");
        else
            System.out.println("ELEMENT IS NOT PRESENT IN ARRAY");
    }

    static boolean positionOfElement(int[] arr , int target){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }
}