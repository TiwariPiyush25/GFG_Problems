class Solution {
    int thirdLargest(int arr[]) {
        int max=Integer.MIN_VALUE;
        int s_max=Integer.MIN_VALUE;
        int t_max=Integer.MIN_VALUE;
        
        for(int ele:arr){
            if(ele>max) {
                t_max=s_max;
                s_max=max;
                max=ele;
            }
            else if(ele>s_max){
                t_max=s_max;
                s_max=ele;
            }
            else if(ele>t_max){
                t_max=ele;
            }
        }
        
            
        if(t_max==Integer.MIN_VALUE) return -1;
        return t_max;
    }
}