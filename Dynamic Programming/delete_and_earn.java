/*

Problem link - https://leetcode.com/problems/delete-and-earn/


Explanation 
In this question we are taking two case
case 1 : if we are considering the number then we are calculating the total by number multiplied by the frequency
case 2 : If we are not considering the number then we take maximum from the last case that we got;

*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        int inc = 0;
        int exc = 0;
        int[] arr = new int[10001];
        //count the frequency of numbers
        for (int i : nums){
            arr[i]++;
        }
        for (int i = 0; i < arr.length; i++){
            //Considering the current number 
            int ni = exc + arr[i]*i;
            //Not considering the current number
            int ne = Math.max(exc,inc);
            inc = ni;
            exc = ne;
        }
        return Math.max(inc,exc);
    }
}
