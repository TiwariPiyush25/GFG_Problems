class Solution {
    public int isPossible(int mid , int[] arr){
        int cnt = 1;
        
        int sum = 0;
        for(int ele : arr){
            if(ele>mid) return Integer.MAX_VALUE;
            if(sum + ele <= mid){
                sum += ele;
            }
            else {
                sum = ele;
                cnt++;
            }
        }
        
        return cnt;
    }
    public int minTime(int[] arr, int k) {
        int st = 0;
        int end = Integer.MAX_VALUE;
        
        int ans = -1;
        while(st <= end){
            int mid = st + (end - st)/2;
            
            if(isPossible(mid,arr) <= k){
                ans = mid;
                end = mid - 1;
            }
            else st = mid + 1;
        }
        
        return ans;
    }
}
