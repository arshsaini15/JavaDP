// minimum number of coins to reach the target sum.

public class DP8 {
    public static int findWays(int coins[], int n, int k){
        if(k == 0){
            return 0;
        }

        if(k < 0){
            return Integer.MAX_VALUE;
        }

        int mincoins=Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int result=findWays(coins, n, k-coins[i]);
            if(result != Integer.MAX_VALUE){
                mincoins = Math.min(mincoins, result+1);
            }
        }

        return mincoins;
    }
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int n=coins.length;
        int target = 11;

        System.out.println(findWays(coins, n, target));
    }
}