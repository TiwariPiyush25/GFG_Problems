class Solution {
    public int findWays(int i,int sum,int total,int[] arr,int[][] dp){
        if(i == arr.length || sum > total){
            if(sum == total) return 1;
            return 0;
        }
        
        if(dp[i][sum] != -1) return dp[i][sum];
        int take = findWays(i+1,sum+arr[i],total,arr,dp);
        int skip = findWays(i+1,sum,total,arr,dp);

        return dp[i][sum] = take + skip;
    }
    public int perfectSum(int[] nums, int target) {
        int[][] dp = new int[nums.length][target+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return findWays(0,0,target,nums,dp);
    }
}