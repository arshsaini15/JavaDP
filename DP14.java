// count of subsets of a given sum.

// Memoization

public class DP14 {
    static int t[][];

    public static int countSets(int arr[], int n, int sum, int t[][]){
        if(sum == 0){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        if(t[n][sum] != 0){
            return t[n][sum];
        }

        if(arr[n-1] <= sum){
            // include + exclude
            t[n][sum] = countSets(arr, n-1, sum-arr[n-1], t) + countSets(arr, n-1, sum, t);
        } else {
            // exclude
            t[n][sum] = countSets(arr, n-1, sum, t);
        }

        return t[n][sum];
    }

    public static void main(String[] args) {
        int arr[]={2,3,5,6,8,10};
        int n=arr.length;
        int sum=10;
        t = new int[n+1][sum+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(i == 0){
                    t[i][j] = 0;
                }
                if(j == 0){
                    t[i][j] = 1;
                }
            }
        }

        System.out.println(countSets(arr, n, sum, t));
    }
}




// recursive approach:

// public static int countSets(int arr[], int n, int sum){
//     if(sum == 0){
//         return 1;
//     }

//     if(n == 0){
//         return 0;
//     }

//     if(arr[n-1] <= sum){
//         return countSets(arr, n-1, sum-arr[n-1]) + countSets(arr, n-1, sum);
//     }

//     return countSets(arr, n-1, sum);
// }

// public static void main(String[] args) {
//     int arr[]={2,3,5,6,8,10};
//     int n=arr.length;
//     int sum=10;
//     t = new int[n+1][sum+1];

//     for(int i=0; i<=n; i++){
//         for(int j=0; j<=sum; j++){
//             if(i == 0){
//                 t[i][j] = 0;
//             }
//             if(j == 0){
//                 t[i][j] = 1;
//             }
//         }
//     }

//     System.out.println(countSets(arr, n, sum));
// }
