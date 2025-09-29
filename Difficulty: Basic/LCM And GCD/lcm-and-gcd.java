class Solution {
    public static int gcd(int a,int b){
        if(a<b){
            int temp=a;
            a=b;
            b=temp;
        }
        
        for(int i=b;i>=1;i--){
            if(b%i==0 && a%i==0) return i;
        }
        
        return -1;
    }
    public static int[] lcmAndGcd(int a, int b) {
       int[] arr=new int[2];
       int GCD=gcd(a,b);
       
       arr[0]=a*b/GCD;
       arr[1]=GCD;
       
       return arr;
    }
}