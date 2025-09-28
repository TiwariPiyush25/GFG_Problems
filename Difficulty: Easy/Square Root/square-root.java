class Solution {
    int floorSqrt(int n) {
        int st=0;
        int end=n;
        
        int ans=-1;
        while(st<=end){
            int mid=(st+end)/2;
            
            if((long) mid*mid<=n){
                ans=mid;
                st=mid+1;
            }
            else end=mid-1;
        }
        
        return ans;
    }
}