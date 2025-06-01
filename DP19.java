// coin change problem -> Minimum number of coins: (Unbounded knapsack).

public class DP19 {
    static int[][] t;

    public static int Knapsack(int coins[], int sum, int n, int[][] t){
        if(sum == 0){
            return 0;
        }
        if(n == 0){
            return Integer.MAX_VALUE-1;
        }

        if (t[n][sum] != -1) {
            return t[n][sum];
        }

        if(coins[n-1] <= sum) {
            t[n][sum] = Math.min(1 + Knapsack(coins, sum-coins[n-1], n, t), Knapsack(coins, sum, n-1, t));
        } else {
            t[n][sum] = Knapsack(coins, sum, n-1, t);
        }
        return t[n][sum];
    }
    public static void main(String[] args) {
        int coins[]={1,2,5};
        int sum=11;
        int n=coins.length;
        t = new int[n+1][sum+1];
        for(int i=0; i<=n; i++){
            for (int j=0; j<=sum; j++){
                if(i == 0){
                    t[i][j] = Integer.MAX_VALUE-1;
                }
                if(j == 0){
                    t[i][j] = 0;
                }
                else if(i > 0){
                    t[i][j] = -1;
                }
            }
        }

        System.out.println(Knapsack(coins, sum, n, t));
    }
}