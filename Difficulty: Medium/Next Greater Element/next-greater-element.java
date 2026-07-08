class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);

        int n = arr.length;
        st.push(arr[n-1]);
        for(int i = n-2;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()) ans.add(0,-1);
            else ans.add(0,st.peek());
            
            st.push(arr[i]);
        }
        
        return ans;
    }
}