/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int levels(Node root){
        if(root==null) return 0;
        
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
    public int height(Node root) {
        
        return levels(root)-1;
    }
}