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
    public List<List<String>> mergeDetails(List<List<String>> details) {
        int n  = details.size();
        parent = new int[n];
        size = new int[n];

        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<details.get(i).size();j++){
                String mail = details.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }
                else {
                    union(i,map.get(mail));
                }
            }
        }
        
        ArrayList<ArrayList<String>> mergedMail = new ArrayList<>();
        for(int i=0;i<n;i++) mergedMail.add(new ArrayList<String>());
        
        for(String key : map.keySet()){
            int node = parent[map.get(key)];
            mergedMail.get(node).add(key);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedMail.get(i).size()==0) continue;
            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));
            
            for(String s:mergedMail.get(i)){
                temp.add(s);
            }
            ans.add(temp);
        }
        
        return ans;
    }
}