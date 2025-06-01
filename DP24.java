// minimum number of insertions and deletion to convert string a to string b.

public class DP24 {
    static int[][] t;

    public static int LCS(String a, String b, int m, int n, int[][] t){
        if(m == 0 || n == 0){
            return 0;
        }
        if(t[m][n] != 0){
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
        String a="heap";
        String b="pea";

        // a->b

        int m=a.length();
        int n=b.length();
        t = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
        
        // number of insertions : a.length()-LCS
        System.out.println(n - LCS(a, b, m, n, t));
        
        // number of deletions: b.length()-LCS
        System.out.println(m - LCS(a, b, m, n, t));
    }
}