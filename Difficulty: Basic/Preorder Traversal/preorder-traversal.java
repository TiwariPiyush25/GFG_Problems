class Solution {
    public void helper(Node root,ArrayList<Integer> ans){
        if(root==null) return;
        
        ans.add(root.data);
        helper(root.left,ans);
        helper(root.right,ans);
    }
    public ArrayList<Integer> preorder(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        helper(root,ans);
        
        return ans;
    }
}