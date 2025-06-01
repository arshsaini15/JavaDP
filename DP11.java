// 0-1 knapsack using memoization

import java.util.Arrays;

public class DP11 {
    static int[][] t;

    public static int knapSack(int wt[], int val[], int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (t[W][n] != -1) {
            return t[W][n];
        }

        if (wt[n - 1] <= W) {
            t[W][n] = Math.max(val[n - 1] + knapSack(wt, val, W - wt[n - 1], n - 1), knapSack(wt, val, W, n - 1));
        }

        return t[W][n];
    }

    public static void main(String[] args) {
        int val[] = {1, 3, 4, 5};
        int wt[] = {1, 4, 5, 7};
        int W = 7;
        int n = val.length;

        t = new int[W + 1][n + 1];
        for (int i = 0; i <= W; i++) {
            Arrays.fill(t[i], -1);
        }

        System.out.println("Maximum value in Knapsack: " + knapSack(wt, val, W, n));
    }
}