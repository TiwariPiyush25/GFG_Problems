class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        ArrayList<Integer> ans=new ArrayList<>();
        
        int max=Integer.MIN_VALUE , min=Integer.MAX_VALUE;
        
        for(int ele:arr){
            if(ele>max) max=ele;
            if(ele<min) min=ele;
        }
        
        ans.add(min); ans.add(max);
        
        return ans;
    }
}
