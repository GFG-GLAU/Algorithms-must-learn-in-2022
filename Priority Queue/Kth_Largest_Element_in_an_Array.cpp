/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5


Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Explanation:-
Using Min Heap/priority_queue
1) Build a Min Heap tree in O(n*log(n)) 
2) Use Extract Max k times to get k maximum elements from the Min Heap O(k*log(n))

Time complexity: O(n*log(n) + k*log(n)) 

*/
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        
        priority_queue <int, vector<int>, greater<int> > pq;
        
        for(int i=0;i<nums.size();i++){
            pq.push(nums[i]);
            
            if(pq.size()>k){
                pq.pop();
            }
        }
        
        return pq.top();
    }
};
