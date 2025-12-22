class Solution {
    static int cost(int i,int j,int[] arr,int[][] dp){
        if (i>=j) return 0;

        if (dp[i][j]!=-1) return dp[i][j];
        int minCost = Integer.MAX_VALUE;
        for (int k=i;k<j;k++){
            int x = arr[i] * arr[k+1] * arr[j+1];
            int totalCost = cost(i,k,arr,dp) + cost(k+1,j,arr,dp) + x;

            minCost = Math.min(totalCost,minCost);
        }

        return dp[i][j] = minCost;
    }
    static int matrixMultiplication(int[] arr) {
        int n = arr.length;

        int[][] dp =  new int[n-1][n-1];
        for (int i=0;i<n-1;i++) Arrays.fill(dp[i],-1);
        return cost(0,n-2,arr,dp);
    }
}