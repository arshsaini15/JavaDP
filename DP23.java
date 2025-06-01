// Shortest Common Supersequence.

public class DP23 {
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

    public static void SCS(String a, String b, int m, int n, int[][] t){
        StringBuilder str = new StringBuilder();

        int i=m, j=n;
        while(i>0 && j>0) {
            if(a.charAt(i-1) == b.charAt(j-1)) {
                str.append(a.charAt(i-1));
                i--;
                j--;
            } else if(t[i-1][j] > t[i][j-1]) {
                str.append(a.charAt(i-1));
                i--;
            } else {
                str.append(b.charAt(j-1));
                j--;
            }
        }

        while(i>0){
            str.append(a.charAt(i-1));
            i--;
        }
        while(j>0){
            str.append(b.charAt(j-1));
            j--;
        }

        str.reverse().toString();
        System.out.println(str);
    }


    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int m=a.length();
        int n=b.length();

        t=new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
        
        // find length of SCS.
        System.out.println(m+n - LCS(a, b, m, n, t));

        // print SCS.
        SCS(a, b, m, n, t);
    }
}