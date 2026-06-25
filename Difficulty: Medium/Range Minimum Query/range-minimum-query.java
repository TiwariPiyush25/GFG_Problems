/* The functions which
builds the segment tree */
class GfG {
    static int SegTree[];
    public static void buildTree(int i,int l,int r,int[] arr){ // TC = O(N) , SC = O(N)
        if (l == r){
            SegTree[i] = arr[l];
            return;
        }

        int mid = (l + r) / 2;
        buildTree((2 * i) + 1,l,mid,arr);
        buildTree((2 * i) + 2,mid + 1,r,arr);

        SegTree[i] = Math.min(SegTree[2*i+1],SegTree[2*i+2]);
    }
    public static int rangeMin(int st,int end,int i,int l,int r){
        if (l > end || r < st) return Integer.MAX_VALUE;
        if (l >= st && r <= end) return SegTree[i];

        int mid = (l + r) / 2;
        return Math.min(rangeMin(st,end,2 * i + 1,l,mid),rangeMin(st,end,2 * i + 2,mid + 1,r));
    }
    public static int[] constructST(int arr[], int n) {
        SegTree = new int[4*n];
        Arrays.fill(SegTree,Integer.MAX_VALUE);
        
        buildTree(0,0,n-1,arr);
        return SegTree;
    }

    public static int RMQ(int st[], int n, int l, int r) {
        return rangeMin(l,r,0,0,n-1);
    }
}