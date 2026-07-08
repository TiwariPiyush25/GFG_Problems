class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);

        int n = arr.length;
        st.push(arr[0]);
        for(int i = 1;i<n;i++){
            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()) ans.add(-1);
            else ans.add(st.peek());
            
            st.push(arr[i]);
        }
        
        return ans;
    }
}