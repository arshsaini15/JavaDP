// Equal Sum partition.

// Memoization:

public class DP13 {
    static boolean t[][];

    public static boolean EqualSum(int arr[], int n, int sum, boolean t[][]) {
        // Base case
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if(t[n][sum]){
            return t[n][sum];
        }

        if (arr[n - 1] <= sum) {
            t[n][sum] = EqualSum(arr, n - 1, sum - arr[n - 1], t) || EqualSum(arr, n - 1, sum, t);
        } else {
            t[n][sum] = EqualSum(arr, n - 1, sum, t);
        }

        return t[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5};
        int n = arr.length;
        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        if (sum % 2 != 0) {
            System.out.println("This array can't be partitioned equally");
        } else {
            int target = sum / 2;

            t = new boolean[n + 1][target + 1];
            for(int i=0; i<=n; i++){
                for(int j=0; j<=target; j++){
                    if(i == 0){
                        t[i][j]=false;
                    }
                    if(j == 0){
                        t[i][j]=true;
                    }
                }
            }

            System.out.println(EqualSum(arr, n, target, t));
        }
    }
}



// recursive approach:

// public static boolean EqualSum(int arr[], int sum, int n, int t[][]){
//     if(sum == 0){
//         return true;
//     }
//     if(n == 0){
//         return false;
//     }

//     if(arr[n-1] <= sum){
//         return EqualSum(arr, sum-arr[n-1], n-1, t) || EqualSum(arr, sum, n-1, t);
//     }

//     return EqualSum(arr, sum, n-1, t);
// }
// public static void main(String[] args) {
//     int arr[] = {1,5,11,5};
//     int n=arr.length;
//     int sum=0;
//     for(int num : arr){
//         sum += num; // sum of all elements of array
//     }

//     t = new int[n+1][sum];

//     if(sum % 2 != 0){
//         System.out.println("This array can't be partitioned equally");
//     } else {
//         System.out.println(EqualSum(arr, sum/2, n, t));
//     }
// }