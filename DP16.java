// Unbounded Knapsack

public class DP16 {
    static int[][] t;

    public static int Knapsack(int arr[], int weight[], int W, int n, int[][] t){
        if(n == 0 || W == 0){
            return 0;
        }

        if(t[n][W] != -1){
            return t[n][W];
        }

        if(weight[n-1] <= W) {
            t[n][W] = Math.max(arr[n-1] + Knapsack(arr, weight, W-weight[n-1], n, t), Knapsack(arr, weight, W, n-1, t));
        } else {
            t[n][W] = Knapsack(arr, weight, W, n-1, t);
        }

        return t[n][W];
    }
    public static void main(String[] args) {
        int[] arr = {10, 40, 50, 70};
        int[] weight = {1, 3, 4, 5};
        int W = 8;
        int n=arr.length;
        t=new int[n+1][W+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=W; j++){
                t[i][j] = -1;
            }
        }
        
        System.out.println(Knapsack(arr, weight, W, n, t));
    }
}