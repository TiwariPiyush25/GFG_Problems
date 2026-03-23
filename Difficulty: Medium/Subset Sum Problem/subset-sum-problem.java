class Solution {
    static boolean findWays(int i,int sum,int total,int[] arr,int[][] dp){
        if(i >= arr.length || sum > total){
            if(sum == total) return true;
            return false;
        }

        if(dp[i][sum] != -1){
            if(dp[i][sum] == 1) return true;
            else  return false;
        }
        boolean take = findWays(i+1,sum+arr[i],total,arr,dp);
        boolean skip = findWays(i+1,sum,total,arr,dp);
        
        boolean flag = take || skip;
        if(flag) dp[i][sum] = 1;
        else dp[i][sum] = 0;
        
        return dp[i][sum] == 1;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        int[][] dp = new int[arr.length][sum+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return findWays(0,0,sum,arr,dp);
    }
}