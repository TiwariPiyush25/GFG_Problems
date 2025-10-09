/* A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Solution {
    void helper(Node root,ArrayList<Integer> ans){
        if(root==null) return;
        
        helper(root.left,ans);
        helper(root.right,ans);
        ans.add(root.data);
    }
    ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        helper(root,ans);
        
        return ans;
    }
}