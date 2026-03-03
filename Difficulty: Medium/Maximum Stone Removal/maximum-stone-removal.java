class Solution {
    public int[] parent;
    public int[] size;
    public int leader(int u){
        if(parent[u]==u) return u;
        
        return parent[u] = leader(parent[u]);
    }
    public void union(int u,int v){
        int a = leader(u);
        int b = leader(v);

        if(a != b){
            if(size[a]  > size[b]){
                parent[b] = a;
                size[a] += size[b];
            }
            else{
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }
    int maxRemove(int[][] stones) {
        int maxrow = 0;
        int maxcol = 0;
        for(int[] stone:stones){
            maxrow = Math.max(maxrow,stone[0]);
            maxcol = Math.max(maxcol,stone[1]);
        }
        
        parent = new int[maxrow + maxcol+2];
        size = new int[maxrow + maxcol+2];

        for(int i = 0;i<parent.length;i++){
            parent[i] = i;
            size[i] = 1;
        }
            
        HashMap<Integer,Integer> stoneNodes = new HashMap<>();
        for(int[] stone : stones){
            int row = stone[0], col = stone[1] + maxrow + 1;
            union(row,col);
            stoneNodes.put(row,1);
            stoneNodes.put(col,1);
        }
        
        int cnt = 0;
        for(int key:stoneNodes.keySet()){
            if(leader(key) == key){
                cnt++;
            }
        }
        
        return stones.length - cnt;
    }
};
