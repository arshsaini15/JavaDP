// Minimum Number Of Coins

public class DP6 {

    public static int countWays(int[] coins, int target, int index, int n){
        if(target == 0){
            return 0;
        }

        if(index >= n){
            return -1;
        }

        if(target<0){
            return Integer.MAX_VALUE;
        }

        for(int i=0; i<n; i++){
            int ans = target-coins[index];
            countWays(coins, target, index+1, n);
        }
    }

    public static void main(String[] args) {
        int coins[] = {1,2,3};
        int target=7;
        int n=coins.length;
        
        countWays(coins, target, 0, n);
        
    }
}