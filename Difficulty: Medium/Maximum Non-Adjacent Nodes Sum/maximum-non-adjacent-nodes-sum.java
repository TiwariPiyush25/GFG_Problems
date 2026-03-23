class Solution {
    public int[] solveDp(Node root){
        if(root == null) return new int[2];
        
        int[] leftResult = solveDp(root.left);
        int[] rightResult = solveDp(root.right);
        int[] currResult = new int[2];
        
        currResult[0] = Math.max(leftResult[0],leftResult[1]) + Math.max(rightResult[0],rightResult[1]);
        currResult[1] = root.data + leftResult[0] + rightResult[0];
        
        return currResult;
    }
    public int getMaxSum(Node root) {
        int[] res = solveDp(root);
        
        return Math.max(res[0],res[1]);
    }
}