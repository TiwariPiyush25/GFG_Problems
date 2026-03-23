class Solution {
    public int helper(int i,int C,int W,int[] val,int[] wt,int[][] dp){
        if(i==val.length){
            return 0;
        }
        
        if(dp[i][C] != -1) return  dp[i][C];
        int skip = helper(i+1,C,W,val,wt,dp);
        if(C + wt[i] > W) return  dp[i][C] = skip;
        
        int take = val[i] + helper(i+1,C+wt[i],W,val,wt,dp);
        
        return dp[i][C] = Math.max(take,skip);
    }
    public int knapsack(int W, int val[], int wt[]) {
        int[][] dp =new int[val.length][W+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        
        return helper(0,0,W,val,wt,dp);
    }
}
