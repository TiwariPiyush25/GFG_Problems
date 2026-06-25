class Solution {
    public int[] segmentTree;
    public void buildTree(int i,int l,int r,int[] arr){ // TC = O(N) , SC = O(N)
        if (l == r){
            segmentTree[i] = arr[l];
            return;
        }

        int mid = (l + r) / 2;
        buildTree((2 * i) + 1,l,mid,arr);
        buildTree((2 * i) + 2,mid + 1,r,arr);

        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }
    public void updateTree(int idx,int val,int i,int l,int r){
        if (l == r){
            segmentTree[i] = val;
            return;
        }

        int mid = (l + r)/2;
        if (idx <= mid){ // move left
            updateTree(idx,val,2 * i + 1, l,mid);
        }
        else { // move right
            updateTree(idx,val,2 * i + 2, mid + 1,r);
        }

        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }
    public int rangeSum(int st,int end,int i,int l,int r){
        if (l > end || r < st) return 0;
        if (l >= st && r <= end) return segmentTree[i];

        int mid = (l + r) / 2;
        return rangeSum(st,end,2 * i + 1,l,mid) + rangeSum(st,end,2 * i + 2,mid + 1,r);
    }
    public List<Integer> querySum(int n, int arr[], int q, int queries[]) {
       segmentTree = new int[n * 4];
       buildTree(0,0,n-1,arr);
       
       List<Integer> ans = new ArrayList<>();
       for(int i = 0;i < q*2;i+=2){
           int l = queries[i],r = queries[i+1];
           ans.add(rangeSum(l-1,r-1,0,0,n-1));
       }
       return ans;
    }
}