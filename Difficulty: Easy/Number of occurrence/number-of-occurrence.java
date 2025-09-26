class Solution {
    int firstindex(int[] arr,int x){
        int st=0;
        int end=arr.length-1;
        int idx=-1;
        while(st<=end){
            int mid=(st+end)/2;
            
            if(arr[mid]==x){
                idx=mid;
                end=mid-1;
            }
            else if(arr[mid]>x) end=mid-1;
            else st=mid+1;
        }
        
        return idx;
    }
    int lastindex(int[] arr,int x){
        int st=0;
        int end=arr.length-1;
        int idx=-1;
        while(st<=end){
            int mid=(st+end)/2;
            
            if(arr[mid]==x){
                idx=mid;
                st=mid+1;
            }
            else if(arr[mid]>x) end=mid-1;
            else st=mid+1;
        }
        
        return idx;
    }
    int countFreq(int[] arr, int target) {
        int first=firstindex(arr,target);
        if(first==-1) return 0;
        int last=lastindex(arr,target);
        
        return last-first+1;
    }
}
