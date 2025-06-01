// minimum cost to reach the top stair: (we can stop at either n-1 or n-2 stair).


import java.util.Arrays;

public class DP7 {
    public static int countWays(int n, int[] cost, int[] dp) {
        if (n == 0) {
            return cost[0];
        }

        if (n == 1) {
            return cost[1];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = cost[n] + Math.min(countWays(n - 1, cost, dp), countWays(n - 2, cost, dp));
        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int n = cost.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(Math.min(countWays(n - 1, cost, dp), countWays(n - 2, cost, dp)));
    }
}