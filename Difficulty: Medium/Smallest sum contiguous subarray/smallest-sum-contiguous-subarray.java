class Solution {
    static int smallestSumSubarray(int arr[], int size) {
        int minSum = arr[0];
        int sum = arr[0];
        
        for(int i=1;i<arr.length;i++){
            sum = Math.min(arr[i],sum+arr[i]);
            minSum = Math.min(minSum,sum);
        }

        return minSum;
    }
}