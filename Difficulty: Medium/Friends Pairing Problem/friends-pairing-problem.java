class Solution {
    public static int pair(int n,int[] dp){
        if (n<=2) return n;
        if (dp[n]!=-1) return dp[n];

        int ans=pair(n-1,dp) + (n-1)*pair(n-2,dp);
        dp[n]=ans;
        return ans;
    }
    public long countFriendsPairings(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return pair(n,dp);
    }
}
