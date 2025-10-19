/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node root) {
        Queue<Node> Q=new LinkedList<>();
        
        Q.add(root);
        ArrayList<Integer> ans=new ArrayList<>();
        while(!Q.isEmpty()){
            int size=Q.size();
            
            for(int i=0;i<size;i++){
                Node temp=Q.remove();
                
                ans.add(0,temp.data);
                if(temp.right!=null) Q.add(temp.right);
                if(temp.left!=null) Q.add(temp.left);
            }
        }
        return ans;
    }
}