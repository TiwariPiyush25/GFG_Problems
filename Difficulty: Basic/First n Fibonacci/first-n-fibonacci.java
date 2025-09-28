// User function Template for Java

class Solution {
    public static int[] fibonacciNumbers(int n) {
        int[] ans=new int[n];
        
        ans[0]=0;
        if(n==1) return ans;

        ans[1]=1;
        if(n==2) return ans;
            
        int a=ans[0];
        int b=ans[1];
            
        for(int i=2;i<n;i++){
            int sum=a+b;
            a=b;
            b=sum;
            
            ans[i]=sum;
        }
        return  ans;
    }
}