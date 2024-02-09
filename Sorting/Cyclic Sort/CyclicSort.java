//JAVA program to sort an array using Cyclic Sort technique

import java.util.*;
public class CyclicSort {
	public static void main(String[] args){
		int[] arr1 = {5, 4, 3, 2, 1};
		int[] arr2 = {1 ,2 ,3 ,4 ,5};
		cyclicSortingAscending(arr1);
	  cyclicSortingDecending(arr2);
	  System.out.println("In Ascending Order");
	  System.out.println(Arrays.toString(arr1));
	  System.out.println("In Descending Order");
	  System.out.println(Arrays.toString(arr2));
	}
	public static void cyclicSortingAscending(int[] arr){
		 int i = 0;
	     while (i < arr.length) {
	    	 int correct = arr[i] - 1;
	         if (arr[i] != arr[correct]){
	        	 swap(arr, i , correct);
	            } 
	         else
	        	 i++;
	        }
	    }
	public static void cyclicSortingDecending(int[] arr){
		 int i = 0;
		 while (i < arr.length) {
			 int correct = i + arr[i];
				if (correct != arr.length){
					swap(arr,i,correct);
				}
				else
					i++;
			}
		}
	  public static void swap(int[] arr, int first, int second) 
	    {
	        int temp = arr[first];
	        arr[first] = arr[second];
	        arr[second] = temp;
	    }
}
