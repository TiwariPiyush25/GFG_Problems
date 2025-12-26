class Solution {
    public class itemValue implements Comparable<itemValue>{
        int profit;
        int weight;

        itemValue(int p,int wt){
            this.profit = p;
            this.weight = wt;
        }

        public int compareTo(itemValue iv){
            double ratio1 = ((double) iv.profit/(double) iv.weight);
            double ratio2 =  ((double)this.profit/(double)this.weight);

            if (ratio1 > ratio2) return 1;
            else return -1;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        itemValue[] arr = new itemValue[val.length];
        for (int i=0;i< val.length;i++){
            arr[i] = new itemValue(val[i],wt[i]);
        }

        Arrays.sort(arr); // sort in decreasing order of p/w ratio

        double profit = 0;
        for (itemValue iv:arr){
            int Pi = iv.profit;
            int Wi = iv.weight;

            if (Wi <= capacity){
                capacity -= Wi;
                profit += Pi;
            }
            else{
                profit += ((double)capacity/(double) Wi) * Pi;
                break;
            }
        }
        return profit;
    }
}