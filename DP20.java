// Longest Common Subsequence (LCS)

// Memoization:

public class DP20 {
    static int[][] t;

    public static int LCS(String X, String Y, int n, int m, int[][] t){
        if(n == 0 || m == 0){
            return 0;
        }

        if(t[n][m] != -1){
            return t[n][m];
        }

        if(X.charAt(n-1) == Y.charAt(m-1)) {
            t[n][m] = 1+LCS(X, Y, n-1, m-1, t);
        } else {
            t[n][m] = Math.max(LCS(X,Y,n-1,m,t), LCS(X, Y, n, m-1, t));
        }

        return t[n][m];
    }
    public static void main(String[] args) {
        String X = "abcdgh";
        String Y = "abedfh";
        int n = X.length();
        int m = Y.length();

        t=new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                t[i][j] = -1;
            }
        }

        System.out.println(LCS(X,Y,n,m,t));
    }
}



// Recursive approach:

// public class DP20 {
//     public static int LCS(String X, String Y, int n, int m) {
//         // base case
//         if (n == 0 || m == 0) {
//             return 0;
//         }

//         if(X.charAt(n-1) == Y.charAt(m-1)){
//             return 1+LCS(X, Y, n-1, m-1);
//         } else {
//             return Math.max(LCS(X, Y, n-1, m), LCS(X, Y, n, m-1));
//         }
//     }

//     public static void main(String[] args) {
//         String X = "abcdgh";
//         String Y = "abedfh";
//         int n = X.length();
//         int m = Y.length();

//         System.out.println(LCS(X, Y, n, m));
//     }
// }
