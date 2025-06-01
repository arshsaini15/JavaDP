// 0-1 Knapsack

public class DP10 {
    public static int knapSack(int wt[], int val[], int W, int n){
        // base case: think of the smallest valid input
        // choice diagram

        if(n == 0 || W == 0) {
            return 0;
        }

        if(wt[n-1] <= W) {
            return Math.max(val[n-1] + knapSack(wt, val, W-wt[n-1], n-1), knapSack(wt, val, W, n-1));
        }

        return knapSack(wt, val, W, n-1);
    }

    public static void main(String[] args) {
        // value of each item.
        int val[] = {1,3,4,5};

        // weight of each item.
        int wt[] = {1,4,5,7};

        // weight of bag
        int W=7;
        int n=val.length;

        System.out.println(knapSack(wt, val, W, n));
    }
}