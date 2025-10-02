class Solution {
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()) return;
        
        int x=st.pop();
        reverseStack(st);
        st.insertElementAt(x,0);
    }
}
