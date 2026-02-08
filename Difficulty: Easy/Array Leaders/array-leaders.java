class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int  n = arr.length;
        int max = arr[n-1];
        boolean flag = true;
        
        for(int i=n-2;i>=0;i--){
            if(flag){
                ans.add(0,max);
                flag = false;
            }
            
            if(arr[i] >= max){
                max = arr[i];
                flag = true;
            }
        }
        
        if(flag){
            ans.add(0,max);
            flag = false;
        }
        
        return ans;
    }
}
