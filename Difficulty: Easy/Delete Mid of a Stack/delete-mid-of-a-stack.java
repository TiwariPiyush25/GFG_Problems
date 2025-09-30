class Solution {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s) {
        Stack<Integer> temp=new Stack<>();
        
        int n=s.size();
        while(s.size()>(n+1)/2){
            temp.push(s.pop());
        }
        
        s.pop();
        
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }
    }
}
