// Matrix Chain Multiplication (MCM)

// Memoization:

public class DP30 {
    static int[][] t;

    public static int solve(int arr[], int i, int j, int[][] t){
        if(i >= j){
            return 0;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }

        int mn=Integer.MAX_VALUE;

        for(int k=i; k<j; k++){
            int temp = solve(arr, i, k, t) + solve(arr, k+1, j, t) + arr[i-1] * arr[k] * arr[j];

            mn= Math.min(mn, temp);
        }

        return t[i][j] = mn;
    }
    public static void main(String[] args) {
        int arr[] = {40,20,30,10,30};
        int n=arr.length;
        t=new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                t[i][j] = -1;
            }
        }

        System.out.println(solve(arr, 1, n-1, t));
    }
}


// Recursive approach:

// public class DP23 {
//     public static int solve(int arr[], int i, int j){
//         if(i >= j){
//             return 0;
//         }

//         int mn=Integer.MAX_VALUE;

//         for(int k=i; k<j; k++){
//             // extra cost
//             int cost = arr[i-1] * arr[k] * arr[j];
//             int temp =solve(arr, i, k) + solve(arr, k+1, j) + cost;
//             if(temp < mn){
//                 mn = temp;
//             }
//         }

//         return mn;
//     }
//     public static void main(String[] args) {
//         int arr[] = {40,20,30,10,30};
//         int n=arr.length;
        
//         System.out.println(solve(arr, 1, n-1));
//     }
// }