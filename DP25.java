// longest palindromic subsequence (return the length of LPS).

public class DP25 {
    static int[][] t;

    public static int LCS(String a, String b, int m, int n, int[][] t){
        if(m == 0 || n == 0){
            return 0;
        }
        if(t[m][n] != -1){
            return t[m][n];
        }
        if(a.charAt(m-1) == b.charAt(n-1)) {
            t[m][n] = 1+LCS(a, b, m-1, n-1, t);
        } else {
            t[m][n] = Math.max(LCS(a, b, m-1, n, t), LCS(a, b, m, n-1, t));
        }

        return t[m][n];
    }
    public static void main(String[] args) {
        String a="bbbab";
        String b = new StringBuilder(a).reverse().toString();
        int m=a.length();
        int n=b.length();

        t=new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                t[i][j] = -1;
            }
        }

        System.out.println(LCS(a, b, m, n, t));
    }
}