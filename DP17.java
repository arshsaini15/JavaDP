// Rod Cutting Problem: (Unbounded Knapsack).

public class DP17 {
    static int[][] t;

    public static int Knapsack(int length[], int price[], int n, int N, int[][] t){
        if(n == 0 || N == 0){
            return 0;
        }

        if(t[n][N] != -1){
            return t[n][N];
        }

        if(length[n-1] <= N) {
            t[n][N] = Math.max(price[n-1] + Knapsack(length, price, n, N-length[n-1], t), 
            Knapsack(length, price, n-1, N, t));
        } else {
            t[n][N] = Knapsack(length, price, n-1, N, t);
        }
        return t[n][N];
    }

    public static void main(String[] args) {
        int[] length={1,2,3,4,5,6,7,8};
        int[] price={1,5,8,9,10,17,17,20};
        int N=8; // length of rod
        int n=price.length;
        t=new int[n+1][N+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=N; j++){
                t[i][j] = -1;
            }
        }

        System.out.println(Knapsack(length, price, n, N, t));
    }
}