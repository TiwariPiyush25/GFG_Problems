class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n-1][n-1];

        for (int i=n-2;i>=0;i--){
            for (int j=0;j<=n-2;j++){
                if (i>=j) dp[i][j] = 0;
                else{
                    int minCost = Integer.MAX_VALUE;
                    for (int k = i;k<j;k++){
                        int x = arr[i] * arr[k+1] * arr[j+1];
                        int totalCost = dp[i][k] + dp[k+1][j] + x;

                        minCost = Math.min(totalCost,minCost);
                    }
                    dp[i][j] = minCost;
                }
            }
        }

        return dp[0][n-2];
    }
}