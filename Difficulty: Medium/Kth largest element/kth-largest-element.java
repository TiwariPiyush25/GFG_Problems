class Solution {
    // Function to return kth largest element from an array.
    public static int KthLargest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int ele:arr){
            pq.add(ele);
            
            if(pq.size()>k) pq.remove();
        }
        
        return pq.peek();
    }
}