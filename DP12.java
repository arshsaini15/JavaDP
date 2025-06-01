// subset sum problem

// Memoization:

public class DP12 {
    static boolean t[][];

    public static boolean knapsack(int arr[], int sum, int n, boolean t[][]){        
        if(sum == 0){
            return true;
        }

        if(n == 0){
            return false;
        }

        if(t[n][sum] != false){
            return t[n][sum];
        }

        if(arr[n-1] <= sum) {
            t[n][sum] = knapsack(arr, sum-arr[n-1], n-1, t) || knapsack(arr, sum, n-1, t);
        } else {
            t[n][sum] = knapsack(arr, sum, n-1, t);
        }

        return t[n][sum]; 
    }

    public static void main(String[] args) {
        int arr[]={2,3,7,8,10};
        int sum=11;
        int n=arr.length;
        t = new boolean[n+1][sum+1];

        for(int i=0; i<=n ;i++){
            for(int j=0; j<=sum; j++){
                if(i == 0){
                    t[i][j] = false;
                }
                if(j == 0){
                    t[i][j] = true;
                }
            }
        }

        System.out.println(knapsack(arr, sum, n, t));
    }
}



// Recursive approach:

// public class DP12 {
//         public static boolean subsetSum(int arr[], int sum, int n){
//         if(sum == 0){
//             return true;
//         }

//         if(n == 0 && sum != 0){
//             return false;
//         }

//         if(arr[n-1] <= sum){
//             return (subsetSum(arr, sum-arr[n-1], n-1) || subsetSum(arr, sum, n-1));
//         }

//         return subsetSum(arr, sum, n-1);
//     }

//     public static void main(String[] args) {
//         int arr[]={2,3,7,8,10};
//         int sum=110;
//         int n=arr.length;

//         System.out.println(subsetSum(arr, sum, n));
//     }
// }