class Solution {
    static boolean armstrongNumber(int n) {
        int copy = n;
        
        int sum = 0;
        while(copy > 0){
            int ld = copy % 10;
            sum = sum + (ld * ld * ld);
            copy /= 10;
        }
        
        return sum == n;
    }
}