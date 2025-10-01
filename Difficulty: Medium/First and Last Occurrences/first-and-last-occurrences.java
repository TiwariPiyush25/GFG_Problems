// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
       ArrayList<Integer> ans=new ArrayList<>();
       
       int st=0;
       int end=arr.length-1;
       int first=-1;
       while(st<=end){
           int mid=(st+end)/2;
           
           if(arr[mid]==x){
               first=mid;
               end=mid-1;
           }
           else if(arr[mid]>x){
               end=mid-1;
           }
           else st=mid+1;
       }
       
       st=0;
       end=arr.length-1;
       int last=-1;
       while(st<=end){
           int mid=(st+end)/2;
           
           if(arr[mid]==x){
               last=mid;
               st=mid+1;
           }
           else if(arr[mid]>x){
               end=mid-1;
           }
           else st=mid+1;
       }
       
       ans.add(first);
       ans.add(last);
       
       return ans;
    }
}
