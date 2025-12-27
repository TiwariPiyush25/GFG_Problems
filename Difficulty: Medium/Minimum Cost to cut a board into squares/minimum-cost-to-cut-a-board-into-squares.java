class Solution {
    public static void reverse(int[] arr){
        int i=0 , j = arr.length - 1;
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
    public static int minCost(int n, int m, int[] Hc, int[] Vc) {
        n = n - 1;
        m = m - 1;
        Arrays.sort(Vc); reverse(Vc);
        Arrays.sort(Hc); reverse(Hc);

        int cost = 0;
        int hzntl = 1, vert = 1;

        int i = 0, j = 0;
        while (i < m && j < n)
        {
            if (Hc[i] > Vc[j])
            {
                cost += Hc[i] * vert;
                hzntl++;
                i++;
            }
            else
            {
                cost += Vc[j] * hzntl;
                vert++;
                j++;
            }
        }

        int total = 0;
        while (i < m) {
            total += Hc[i++];
        }
        cost += total * vert;

        total = 0;
        while (j < n) {
            total += Vc[j++];
        }
        cost += total * hzntl;

        return cost;
    }
}
