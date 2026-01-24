// User function Template for Java

class Solution {
    public class pair{
        int step;
        int num;
        
        pair(int s,int n){
            this.step = s;
            this.num = n;
        }
    }
    int minimumMultiplications(int[] arr, int st, int end) {
        if(st == end) return 0;
        
        int[] dist =  new int[100000];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,st));
        
        while(!q.isEmpty()){
            pair top = q.remove();
            int step = top.step, num = top.num;
            
            for(int ele:arr){
                int val = (ele * num) % 100000;
                if(dist[val] > step+1){
                    q.add(new pair(step+1,val));
                    dist[val] = step+1;
                    
                    if(val == end) return step + 1;
                }
            }
        }
        
        return -1;
    }
}
