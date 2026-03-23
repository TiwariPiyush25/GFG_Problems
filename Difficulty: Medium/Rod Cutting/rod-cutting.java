class Solution {
    public int helper(int i,int l,int n,int[] arr,int[][] dp){
        if(i==n || l>n){
            if(l == n){
                return 0;
            }
            
            return Integer.MIN_VALUE;
        }
        
        if(dp[i][l] != -1) return dp[i][l];
        int take = arr[i] + helper(i,l+i+1,n,arr,dp);
        int skip = helper(i+1,l,n,arr,dp);
        
        return dp[i][l] = Math.max(take,skip);
    }
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return helper(0,0,n,price,dp);
    }
}