class Solution {
    public int getSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE, smax = Integer.MIN_VALUE;
        
        for(int ele : arr){
            if(ele > max){
                smax = max;
                max = ele;
            }
            else if(ele > smax && ele != max){
                smax = ele;
            }
        }
        
        return smax == Integer.MIN_VALUE ? -1 : smax;
    }
}