// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int ele:arr){
            p.add(ele);
            
            if(p.size()>k) p.remove();
        }
        
        return p.peek();
    }
}
