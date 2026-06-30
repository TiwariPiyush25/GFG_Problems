class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int sum = 0;
        
        for(int i=0;i < k;i++){
            sum += arr[i];
        }
        
        int maxSum = sum;
        
        int st = 0;
        int end = k;
        while(end < arr.length){
            sum -= arr[st];
            sum += arr[end];
            
            maxSum = Math.max(maxSum,sum);
            end++;
            st++;
        }
        
        return maxSum;
    }
}