class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if(k<=q.size()){
            Stack<Integer> st=new Stack<>();
            while(k-->0){
                st.push(q.remove());
            }
            
            k=st.size();
            while(!st.isEmpty()){
                q.add(st.pop());
            }
            
            int rem=q.size()-k;
            
            while(rem-->0){
                q.add(q.remove());
            }
        }
        
        return q;
    }
}