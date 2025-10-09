class Solution {
    public List<Integer> frequencyCount(int[] arr) {
        List<Integer> lst=new ArrayList<>();
        int n=arr.length;
        while(n-->0) lst.add(0);
        
        for(int ele:arr){
            int val=lst.get(ele-1);
            lst.set(ele-1,val+1);
        }
        
        return lst;
    }
}
