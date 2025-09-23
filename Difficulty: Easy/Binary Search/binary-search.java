class Solution {
    public int binarysearch(int[] arr, int k) {
        int st=0;
        int end=arr.length-1;
        int ans=-1;
        while(st<=end){
            int mid=(st+end)/2;
            
            if(arr[mid]==k){
                ans=mid;
                end=mid-1;
            }
            else if(arr[mid]>k) end=mid-1;
            else st=mid+1;
        }
        
        return ans;
    }
}