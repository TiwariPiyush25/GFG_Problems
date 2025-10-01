class Solution {
    void helper(Node root,ArrayList<Integer> ans){
        if(root==null) return;
        
        helper(root.left,ans);
        ans.add(root.data);
        helper(root.right,ans);
    }
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        helper(root,ans);
        
        return ans;
    }
}