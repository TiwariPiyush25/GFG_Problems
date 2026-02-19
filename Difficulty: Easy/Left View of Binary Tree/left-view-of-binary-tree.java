/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        if(root==null) return new ArrayList<>();
        
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> a = new ArrayList<>();
            for(int i=0;i<n;i++){
                Node t = q.remove();
                
                a.add(t.data);
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            temp.add(a);
        }
        
    
        ArrayList<Integer> ans = new ArrayList<>();
        for(ArrayList<Integer> a:temp){
            ans.add(a.get(0));
        }
        
        return ans;
    }
}