class Solution {
    public static int findEquilibrium(int arr[]) {
        int sum = 0;
        for(int ele : arr) sum += ele;
        
        int currSum = 0;
        for(int i = 0;i < arr.length;i++){
            sum -= arr[i];
            if(sum == currSum) return i;
            currSum += arr[i];
        }
        
        return -1;
    }
}
